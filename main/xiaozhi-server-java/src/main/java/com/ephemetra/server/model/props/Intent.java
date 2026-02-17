package com.ephemetra.server.model.props;

import lombok.Data;

import java.util.List;

@Data
public class Intent {

    /**
     * 不使用意图识别
     */
    public NoIntent nointent;

    /**
     * 基于LLM的意图识别
     */
    public IntentLlm intentLlm;

    /**
     * 基于Function Call的意图识别
     */
    public FunctionCall functionCall;

    @Data
    public static class NoIntent {
        public String type;
    }

    @Data
    public static class IntentLlm {
        public String type;
        public String llm;
        public List<String> functions;
    }

    @Data
    public static class FunctionCall {
        public String type;
        public List<String> functions;
    }
}