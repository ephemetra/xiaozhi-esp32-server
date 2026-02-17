package com.ephemetra.server.model.props;

import lombok.Data;

@Data
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