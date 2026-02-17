package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class Llm {

    /**
     * 阿里云百炼大模型 (标准OpenAI格式)
     */
    public AliLLM aliLLM;

    /**
     * 阿里云百炼应用 (应用工作流模式)
     */
    public AliAppLLM aliAppLLM;

    /**
     * 字节跳动豆包大模型
     */
    public DoubaoLLM doubaoLLM;

    /**
     * DeepSeek 大模型
     */
    public DeepSeekLLM deepSeekLLM;

    /**
     * 智谱 AI ChatGLM
     */
    public ChatGLMLLM chatGLMLLM;

    /**
     * Ollama 本地模型服务
     */
    public OllamaLLM ollamaLLM;

    /**
     * Dify 工作流或对话 API
     */
    public DifyLLM difyLLM;

    /**
     * 谷歌 Gemini 大模型
     */
    public GeminiLLM geminiLLM;

    /**
     * 字节跳动 Coze (扣子)
     */
    public CozeLLM cozeLLM;

    /**
     * 火山引擎边缘大模型网关
     */
    public VolcesAiGatewayLLM volcesAiGatewayLLM;

    /**
     * LM Studio 本地模型服务
     */
    public LMStudioLLM lmStudioLLM;

    /**
     * Home Assistant 对话代理
     */
    public HomeAssistant homeAssistant;

    /**
     * FastGPT 应用 API
     */
    public FastgptLLM fastgptLLM;

    /**
     * Xinference 本地大模型推理框架
     */
    public XinferenceLLM xinferenceLLM;

    /**
     * Xinference 轻量级推理框架 (意图识别专用)
     */
    public XinferenceSmallLLM xinferenceSmallLLM;

}