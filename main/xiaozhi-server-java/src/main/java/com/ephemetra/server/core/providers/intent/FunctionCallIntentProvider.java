package com.ephemetra.server.core.providers.intent;

import com.ephemetra.server.config.MainConfig;
import com.ephemetra.server.core.ConnectionHandler;

import java.util.List;

public class FunctionCallIntentProvider extends IntentBaseProvider {
    public FunctionCallIntentProvider(MainConfig config) {
        super(config);
    }

    @Override
    public String detectIntent(ConnectionHandler conn, List<String> dialogueHistory, String text) {
        return "";
    }
}
