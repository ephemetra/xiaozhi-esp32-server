package com.ephemetra.server.core.providers.intent;

import com.ephemetra.server.config.XiaozhiConfig;
import com.ephemetra.server.core.ConnectionHandler;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
public abstract class IntentBaseProvider {
    private final XiaozhiConfig config;

    @Setter
    private Object llm;

    /**
     * 检测用户最后一句话的意图
     *
     * @return
     */
    public abstract String detectIntent(ConnectionHandler conn, List<String> dialogueHistory, String text);
}