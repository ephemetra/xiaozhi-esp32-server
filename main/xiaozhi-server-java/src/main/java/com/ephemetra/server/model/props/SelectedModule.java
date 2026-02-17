package com.ephemetra.server.model.props;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SelectedModule {

    /**
     * 语音活动检测模块 (如: SileroVAD)
     */
    @JsonProperty("VAD")
    public String vad;

    /**
     * 语音识别模块 (如: FunASR)
     */
    @JsonProperty("ASR")
    public String asr;

    /**
     * 语言大模型适配器 (如: ChatGLMLLM)
     */
    public String llm;

    /**
     * 视觉语言大模型 (如: ChatGLMVLLM)
     */
    public String vllm;

    /**
     * 语音合成模块 (如: EdgeTTS)
     */
    public String tts;

    /**
     * 记忆模块 (如: nomem, mem0ai)
     */
    public String memory;

    /**
     * 意图识别模块 (如: function_call, nointent)
     */
    public String intent;
}