package com.ephemetra.server.core.providers.vad;

import com.ephemetra.server.config.XiaozhiConfig;
import com.ephemetra.server.core.ConnectionHandler;

public class SileroVADBaseProvider extends VADBaseProvider {

    public SileroVADBaseProvider(XiaozhiConfig config) {
        super(config);
    }

    @Override
    public boolean isVad(ConnectionHandler conn, byte[] audio) {
        return false;
    }
}
