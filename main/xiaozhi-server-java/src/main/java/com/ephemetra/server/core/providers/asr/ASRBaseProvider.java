package com.ephemetra.server.core.providers.asr;

import com.ephemetra.server.config.XiaozhiConfig;
import com.ephemetra.server.core.ConnectionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class ASRBaseProvider {
    private final XiaozhiConfig config;

    /**
     * 打开音频通道
     */
    public abstract void openAudioChannels(ConnectionHandler conn);

    /**
     * 有序处理ASR音频
     */
    public abstract void asrTextPriorityThread(ConnectionHandler conn);

    /**
     * 接收音频
     */
    public abstract void receiveAudio(ConnectionHandler conn, byte[] audio, boolean haveVoice);

    /**
     * 处理语音停止
     */
    public abstract void handleVoiceStop(ConnectionHandler conn, List<byte[]> asrAudioTask);

    /**
     * 构建包含说话人信息的JSON字符串
     */
    protected String buildEnhancedText(String text, Optional<String> speakerName) {
        return "";
    }

    /**
     * pcm转wav
     */
    protected String pcmToWav(byte[] pcmData) {
        return "";
    }

    public void stopWsConnection() {
    }

    /**
     * 保存音频文件到本地
     */
    public String saveAudioToFile(byte[] pcmData, String sessionId) {
        return "";
    }

    public String speechToText(byte[] opusData, String sessionId) {
        return speechToText(opusData, sessionId, "opus");
    }

    @Async
    public abstract String speechToText(byte[] opusData, String sessionId, String audioFormat);

    public abstract byte[] decodeOpus(byte[] opusData);
}
