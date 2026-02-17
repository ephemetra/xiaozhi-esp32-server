package com.ephemetra.server.model.props;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Asr {

    /**
     * 本地 FunASR 模型
     */
    @JsonProperty("ASR_FunASR")
    public FunAsr funAsr;

    /**
     * 远程 FunASR 服务
     */
    public FunAsrServer funAsrServer;

    /**
     * Sherpa-ONNX 本地语音识别
     */
    public SherpaAsr sherpaAsr;

    /**
     * Sherpa-Paraformer 小型化本地识别
     */
    public SherpaParaformerAsr sherpaParaformerAsr;

    /**
     * 字节跳动豆包 ASR（非流式）
     */
    public DoubaoAsr doubaoAsr;

    /**
     * 字节跳动豆包 ASR（流式）
     */
    public DoubaoStreamAsr doubaoStreamAsr;

    /**
     * 腾讯云 ASR
     */
    public TencentAsr tencentAsr;

    /**
     * 阿里云 ASR（非流式）
     */
    public AliyunAsr aliyunAsr;

    /**
     * 阿里云 ASR（流式）
     */
    public AliyunStreamAsr aliyunStreamAsr;

    /**
     * 百度云 ASR
     */
    public BaiduAsr baiduAsr;

    /**
     * OpenAI Whisper ASR
     */
    public OpenaiAsr openaiAsr;

    /**
     * Groq Cloud ASR
     */
    public GroqAsr groqAsr;

    /**
     * Vosk 离线语音识别
     */
    public VoskAsr voskAsr;

    /**
     * 阿里云百炼 Qwen3-ASR-Flash
     */
    public Qwen3AsrFlash qwen3AsrFlash;

    /**
     * 讯飞流式语音识别
     */
    public XunfeiStreamAsr xunfeiStreamAsr;

    /**
     * 阿里云百炼 Paraformer 实时识别
     */
    public AliyunBlStreamAsr aliyunBlStreamAsr;
}