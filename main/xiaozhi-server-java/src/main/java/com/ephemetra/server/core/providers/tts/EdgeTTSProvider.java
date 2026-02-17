package com.ephemetra.server.core.providers.tts;

import com.ephemetra.server.config.MainConfig;
import com.ephemetra.server.core.ConnectionHandler;

import java.io.File;
import java.util.function.Function;

public class EdgeTTSProvider extends TTSBaseProvider {
    public EdgeTTSProvider(MainConfig config) {
        super(config);
    }

    @Override
    public String generateFilename(String extension) {
        return "";
    }

    @Override
    public void handleOpus(byte[] opusData) {

    }

    @Override
    public void handleAudioFile(byte[] fileAudio, String text) {

    }

    @Override
    public void toTtsStream(String text, Object opusHandler) {

    }

    @Override
    public String toTts(String text) {
        return "";
    }

    @Override
    public String textToSpeak(String text, File outputFile) {
        return "";
    }

    @Override
    public String audioToPcmDataStream(String audioFilePath, Function callback) {
        return "";
    }

    @Override
    public String audioToOpusDataStream(String audioFilePath, Function callback) {
        return "";
    }

    @Override
    public String openAudioChannels(ConnectionHandler conn) {
        return "";
    }

    @Override
    public String ttsTextPriorityThread() {
        return "";
    }

    @Override
    public String startSession(String sessionId) {
        return "";
    }

    @Override
    public String finishSession(String sessionId) {
        return "";
    }

    @Override
    public String close() {
        return "";
    }
}
