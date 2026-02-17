package com.ephemetra.server.core.providers.memory;

import com.ephemetra.server.config.MainConfig;

public class NoMemoryProvider extends MemoryBaseProvider {
    public NoMemoryProvider(MainConfig config) {
        super(config);
    }

    @Override
    public String queryMemory(String query) {
        return "";
    }

    @Override
    public String initMemory(String roleId, Object llm) {
        return "";
    }
}
