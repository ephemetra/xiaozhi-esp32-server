package com.ephemetra.server.core.providers.vllm;

import com.ephemetra.server.config.XiaozhiConfig;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class VLLMBaseProvider {
    private final XiaozhiConfig config;

    public abstract String response(String question, String base64Image);
}
