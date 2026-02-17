package com.ephemetra.server.model.props;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Vllm {

    /**
     * 智谱 AI 视觉模型
     */
    public ChatGLMVLLM chatGLMVLLM;

    /**
     * 阿里云通义千问视觉模型
     */
    public QwenVLVLLM qwenVLVLLM;

    /**
     * 讯飞星火视觉模型
     */
    public XunfeiSparkLLM xunfeiSparkLLM;

}