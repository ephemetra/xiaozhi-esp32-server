package com.ephemetra.server.core.providers.memory;

import com.ephemetra.server.config.XiaozhiConfig;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public abstract class MemoryBaseProvider {
    private final XiaozhiConfig config;

    @Setter
    private Object llm;

    public abstract String queryMemory(String query);

    public abstract String initMemory(String roleId, Object llm);
}