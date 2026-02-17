package com.ephemetra.server.core.providers.asr;

import com.ephemetra.server.config.XiaozhiConfig;
import com.ephemetra.server.core.ConnectionHandler;

public class XunfeiStreamASRBaseProvider extends ASRBaseProvider {
    public XunfeiStreamASRBaseProvider(XiaozhiConfig config) {
        super(config);
    }

    @Override
    public void openAudioChannels(ConnectionHandler conn) {

    }
}
