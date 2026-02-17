package com.ephemetra.server.core.providers.asr;

import com.ephemetra.server.config.XiaozhiConfig;
import com.ephemetra.server.core.ConnectionHandler;

public class DoubaoStreamASRBaseProvider extends ASRBaseProvider {
    public DoubaoStreamASRBaseProvider(XiaozhiConfig config) {
        super(config);
    }

    @Override
    public void openAudioChannels(ConnectionHandler conn) {

    }
}
