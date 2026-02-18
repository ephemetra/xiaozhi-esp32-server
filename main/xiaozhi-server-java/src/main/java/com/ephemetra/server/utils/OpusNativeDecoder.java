package com.ephemetra.server.utils;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;


/**
 * <h2>Opus 音频解码器 (Java Native 绑定)</h2>
 * * <p>本类通过 JNA 调用系统底层的 libopus 库，实现将 Opus 压缩数据解码为 PCM 格式。逻辑对标 Python opuslib_next.Decoder</p>
 * * <h3>1. 环境依赖说明 (Prerequisites):</h3>
 * <ul>
 * <li><b>Linux (Ubuntu/Debian):</b> 运行 {@code sudo apt-get install libopus-dev}</li>
 * <li><b>Linux (CentOS/RHEL):</b> 运行 {@code sudo yum install opus-devel}</li>
 * <li><b>Windows:</b> 需要将 {@code opus.dll} 放置在项目根目录或 {@code C:\Windows\System32}</li>
 * <li><b>macOS:</b> 运行 {@code brew install opus}</li>
 * </ul>
 * * <h3>2. Maven 依赖:</h3>
 * <pre>{@code
 * <dependency>
 * <groupId>net.java.dev.jna</groupId>
 * <artifactId>jna</artifactId>
 * <version>5.13.0</version>
 * </dependency>
 * }</pre>
 * * <h3>3. 使用示例:</h3>
 * <pre>{@code
 * try (OpusNative decoder = new OpusNative(16000, 1)) {
 * byte[] pcm = decoder.decode(opusData, 960);
 * }
 * }</pre>
 */
public class OpusNativeDecoder implements AutoCloseable {

    // --- 1. 定义 C 库映射接口 ---
    public interface LibOpus extends Library {
        // 自动根据操作系统加载 libopus.so (Linux) 或 opus.dll (Windows)
        LibOpus INSTANCE = Native.load("opus", LibOpus.class);

        /**
         * 创建解码器
         * @param Fs 采样率 (8000, 12000, 16000, 24000, 48000)
         * @param channels 通道数 (1 或 2)
         * @param error 错误码输出
         * @return 解码器指针
         */
        Pointer opus_decoder_create(int Fs, int channels, int[] error);

        /**
         * 解码 Opus 数据包为 PCM
         * @param st 解码器指针
         * @param data 输入的 opus 字节数组
         * @param len 数据长度
         * @param pcm 输出的 short 数组
         * @param frame_size 每通道的样本数（如 960）
         * @param decode_fec 是否启用前向纠错 (0=不启用)
         * @return 实际解码出的每通道样本数，负数为错误码
         */
        int opus_decode(Pointer st, byte[] data, int len, short[] pcm, int frame_size, int decode_fec);

        /**
         * 销毁解码器，释放 C 堆内存
         */
        void opus_decoder_destroy(Pointer st);
    }

    // --- 2. 成员变量 ---
    private final Pointer decoder;
    private final int channels;
    private boolean isClosed = false;

    /**
     * 初始化解码器
     * @param sampleRate 采样率，例如 16000
     * @param channels 通道数，例如 1
     */
    public OpusNativeDecoder(int sampleRate, int channels) {
        this.channels = channels;
        int[] error = new int[1];
        this.decoder = LibOpus.INSTANCE.opus_decoder_create(sampleRate, channels, error);
        
        if (error[0] != 0 || decoder == null) {
            throw new RuntimeException("无法创建 Opus 解码器，错误码: " + error[0]);
        }
    }

    /**
     * 解码方法
     * @param opusData 输入二进制数据
     * @param frameSize 期待的帧大小（对应 Python 的 decode(data, 960) 中的 960）
     * @return 小端序的 PCM byte[]
     */
    public byte[] decode(byte[] opusData, int frameSize) {
        if (isClosed) throw new IllegalStateException("解码器已关闭");
        if (opusData == null) return null;

        // 准备输出缓冲区
        short[] pcmBuffer = new short[frameSize * channels];
        
        // 调用 C 函数
        int result = LibOpus.INSTANCE.opus_decode(
                decoder, 
                opusData, 
                opusData.length, 
                pcmBuffer, 
                frameSize, 
                0
        );

        if (result < 0) {
            System.err.println("Opus 解码失败，错误码: " + result);
            return null;
        }

        // 将 short[] 转换为小端序 byte[] (Little-Endian)
        // 这种方式比手动循环更高效且易读
        ByteBuffer byteBuffer = ByteBuffer.allocate(result * channels * 2);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        for (int i = 0; i < result * channels; i++) {
            byteBuffer.putShort(pcmBuffer[i]);
        }

        return byteBuffer.array();
    }

    /**
     * 显式释放资源
     */
    @Override
    public void close() {
        if (!isClosed && decoder != null) {
            LibOpus.INSTANCE.opus_decoder_destroy(decoder);
            isClosed = true;
        }
    }
}