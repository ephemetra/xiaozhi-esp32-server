package com.ephemetra.server.core.providers.llm;

import com.ephemetra.server.config.MainConfig;

import java.util.List;

public class ChatGLMLLMProvider extends LLMBaseProvider {
    public ChatGLMLLMProvider(MainConfig config) {
        super(config);
    }

    @Override
    public String responseNoStream(String systemPrompt, String userPrompt) {
        return "";
    }

    @Override
    public List<String> responseWithFunctions(String sessionId, String userPrompt) {
        return List.of();
    }
}
