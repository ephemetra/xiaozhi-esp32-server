package com.ephemetra.server.core.providers.vad;

import com.ephemetra.server.config.MainConfig;
import com.ephemetra.server.core.ConnectionHandler;

public class SileroVADProvider extends VADBaseProvider {

    public SileroVADProvider(MainConfig config) {
        super(config);
    }

    @Override
    public boolean isVad(ConnectionHandler conn, byte[] audio) {
        return false;
    }
}
