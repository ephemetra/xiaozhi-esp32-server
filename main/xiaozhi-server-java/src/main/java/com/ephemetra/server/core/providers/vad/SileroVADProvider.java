package com.ephemetra.server.core.providers.vad;

import com.ephemetra.server.config.MainConfig;
import com.ephemetra.server.core.ConnectionHandler;
import com.ephemetra.server.utils.OpusNativeDecoder;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Optional;

@Slf4j
public class SileroVADProvider extends VADBaseProvider {

    private int frameWindowThreshold;
    private Float vadThreshold;
    private Float vadThresholdLow;
    private Integer minSilenceDurationMs;


    public SileroVADProvider(MainConfig config) {
        super(config);
        super.decoder = new OpusNativeDecoder(16000, 1);
        this.vadThreshold = Optional.ofNullable(config.vad.sileroVAD.threshold).orElse(0.5f);
        this.vadThresholdLow = Optional.ofNullable(config.vad.sileroVAD.thresholdLow).orElse(0.2f);
        this.minSilenceDurationMs = Optional.ofNullable(config.vad.sileroVAD.minSilenceDurationMs).orElse(1000);
        // 至少要多少帧才算有语音
        this.frameWindowThreshold = 3;
    }

    public boolean isVad(ConnectionHandler conn, byte[] opusPacket) {
        // 手动模式：直接返回True，不进行实时VAD检测，所有音频都缓存
        if ("manual".equals(conn.clientListenMode)) {
            return true;
        }
        try {
            byte[] pcmFrame = this.decoder.decode(opusPacket, 960);
            conn.clientAudioBuffer.writeBytes(pcmFrame);    // 将新数据加入缓冲区
            // 处理缓冲区中的完整帧（每次处理512采样点）
            boolean clientHaveVoice = false;
            int frameSize = 512 * 2;
            while (conn.clientAudioBuffer.readableBytes() >= frameSize) {
                // 提取前512个采样点（1024字节）
                byte[] chunk = new byte[frameSize];
                conn.clientAudioBuffer.readBytes(chunk);
                // 转换为模型需要的张量格式
                float[] audioFloat32 = convertToFloat(chunk);
                // 使用模型，检测语音活动
                float speechProb = this.vadModel.predict(audioFloat32, 16000);

                // 阈值判断
                boolean isVoice;
                if (speechProb >= this.vadThreshold) {
                    isVoice = true;
                } else if (speechProb <= this.vadThresholdLow) {
                    isVoice = false;
                } else {
                    isVoice = conn.lastIsVoice; // 处于中间地带，保持上一帧状态
                }
                // 声音没低于最低值则延续前一个状态，判断为有声音
                conn.lastIsVoice = isVoice;

                // 更新滑动窗口
                conn.clientVoiceWindow.add(isVoice);
                while (conn.clientVoiceWindow.size() > conn.maxWindowSize) {
                    conn.clientVoiceWindow.remove(0);
                }
                // 判断当前窗口内是否有足够多的“语音帧”
                clientHaveVoice = conn.clientVoiceWindow.stream().filter(b -> b).count() >= this.frameWindowThreshold;

                // 如果之前有声音，但本次没有声音，且与上次有声音的时间差已经超过了静默阈值，则认为已经说完一句话
                if (conn.clientHaveVoice && !clientHaveVoice) {
                    // 之前在说，现在没声了，检查静默时长
                    long stopDuration = System.currentTimeMillis() - conn.lastActivityTime;
                    if (stopDuration >= this.minSilenceDurationMs) {
                        conn.clientVoiceStop = true;
                    }
                }
                if (clientHaveVoice) {
                    conn.clientHaveVoice = true;
                    conn.lastActivityTime = System.currentTimeMillis();
                }
            }
            conn.clientAudioBuffer.discardReadBytes();  // 丢弃已读字节，优化 ByteBuf 空间
            return clientHaveVoice;

        } catch (Exception e) {
            log.error("Error processing audio packet", e);
            return false;
        }
    }

    /**
     * 将16-bit PCM 小端序（Little Endian）音频数据 转化为 归一化的浮点数 （张量格式）
     */
    private float[] convertToFloat(byte[] chunk) {
        // 1. 将字节数组包装为 ByteBuffer，并设置小端序
        ByteBuffer buffer = ByteBuffer.wrap(chunk);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        // 2. 计算采样点数量 (每个 int16 占 2 字节)
        int samples = chunk.length / 2;
        float[] audioFloat32 = new float[samples];
        for (int i = 0; i < samples; i++) {
            // 3. 读取一个 short (16-bit 整数) 并归一化到 [-1.0, 1.0]
            short audioInt16 = buffer.getShort();
            audioFloat32[i] = audioInt16 / 32768.0f;
        }
        return audioFloat32;
    }
}
