package com.ephemetra.server.core.providers.llm;

import com.ephemetra.server.config.XiaozhiConfig;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class LLMBaseProvider {
    private final XiaozhiConfig config;

    /**
     * 请求大模型生成回复
     */
    public abstract String responseNoStream(String systemPrompt, String userPrompt);

    /**
     * 流式调用 function calling
     */
    public abstract List<String> responseWithFunctions(String sessionId, String userPrompt);
}
