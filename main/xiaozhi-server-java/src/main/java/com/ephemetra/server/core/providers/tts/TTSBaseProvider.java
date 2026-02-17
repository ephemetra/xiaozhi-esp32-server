package com.ephemetra.server.core.providers.tts;

import com.ephemetra.server.config.XiaozhiConfig;
import com.ephemetra.server.core.ConnectionHandler;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.util.function.Function;

@RequiredArgsConstructor
public abstract class TTSBaseProvider {
    private final XiaozhiConfig config;

    public String generateFilename() {
        return this.generateFilename(".wav");
    }

    public abstract String generateFilename(String extension);

    public abstract void handleOpus(byte[] opusData);

    public abstract void handleAudioFile(byte[] fileAudio, String text);

    public void toTtsStream(String text) {
        toTtsStream(text, null);
    }

    public abstract void toTtsStream(String text, Object opusHandler);

    public abstract String toTts(String text);

    public abstract String textToSpeak(String text, File outputFile);

    public abstract String audioToPcmDataStream(String audioFilePath, Function callback);

    public abstract String audioToOpusDataStream(String audioFilePath, Function callback);

    public void ttsOneSentence(ConnectionHandler conn, Object contentType, String contentDetail, String contentFile, String sentenceId) {

    }

    public abstract String openAudioChannels(ConnectionHandler conn);

    public abstract String ttsTextPriorityThread();

    protected void audioPlayPriorityThread() {

    }

    public abstract String startSession(String sessionId);

    public abstract String finishSession(String sessionId);

    public abstract String close();


    protected void getSegmentText() {

    }

    protected void processAudioFileStream(String ttsFile, Function callback) {

    }

    protected void processBeforeStopPlayFiles() {

    }

    protected void processRemainingTextStream(Function opusHandler) {

    }
}