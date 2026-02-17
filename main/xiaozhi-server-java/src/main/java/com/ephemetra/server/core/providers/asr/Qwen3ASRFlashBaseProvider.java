package com.ephemetra.server.core.providers.asr;

import com.ephemetra.server.config.XiaozhiConfig;
import com.ephemetra.server.core.ConnectionHandler;

public class Qwen3ASRFlashBaseProvider extends ASRBaseProvider {
    public Qwen3ASRFlashBaseProvider(XiaozhiConfig config) {
        super(config);
    }

    @Override
    public void openAudioChannels(ConnectionHandler conn) {

    }
}
