package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class Memory {

    /**
     * mem0ai 配置
     */
    public Mem0ai mem0ai;

    /**
     * 不使用记忆功能
     */
    public Nomem nomem;

    /**
     * 本地记忆功能
     */
    public MemLocalShort memLocalShort;

    @Data
    public static class Mem0ai {
        public String type;
        public String apiKey;
    }

    @Data
    public static class Nomem {
        public String type;
    }

    @Data
    public static class MemLocalShort {
        public String type;
        public String llm;
    }
}