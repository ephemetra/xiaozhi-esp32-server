package com.ephemetra.server.core.providers.asr;

import com.ephemetra.server.config.MainConfig;
import com.ephemetra.server.core.ConnectionHandler;

import java.util.List;

public class FunASRProvider extends ASRBaseProvider {
    public FunASRProvider(MainConfig config) {
        super(config);
    }

    @Override
    public void openAudioChannels(ConnectionHandler conn) {

    }

    @Override
    public void asrTextPriorityThread(ConnectionHandler conn) {

    }

    @Override
    public void receiveAudio(ConnectionHandler conn, byte[] audio, boolean haveVoice) {

    }

    @Override
    public void handleVoiceStop(ConnectionHandler conn, List<byte[]> asrAudioTask) {

    }

    @Override
    public String speechToText(byte[] opusData, String sessionId, String audioFormat) {
        return "";
    }

    @Override
    public byte[] decodeOpus(byte[] opusData) {
        return new byte[0];
    }
}
