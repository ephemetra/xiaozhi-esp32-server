package com.ephemetra.server.config;

import org.springframework.stereotype.Component;

@Component
public class ConfigLoader {

    private static XiaozhiConfig config;

    public ConfigLoader(XiaozhiConfig config) {
        ConfigLoader.config = config;
    }

    public static XiaozhiConfig loadConfig() {
        return config;
    }
}
