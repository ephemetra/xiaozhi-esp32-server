package com.ephemetra.server.model.props;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Tts {

    /**
     * 微软 Edge TTS
     */
    public EdgeTTS edgeTTS;

    /**
     * 字节跳动豆包 TTS
     */
    public DoubaoTTS doubaoTTS;

    /**
     * 火山引擎双向流式 TTS
     */
    public HuoshanDoubleStreamTTS huoshanDoubleStreamTTS;

    /**
     * 硅基流动 CosyVoice
     */
    public CosyVoiceSiliconflow cosyVoiceSiliconflow;

    /**
     * Coze CN TTS
     */
    public CozeCnTTS cozeCnTTS;

    /**
     * 火山引擎边缘网关 TTS
     */
    public VolcesAiGatewayTTS volcesAiGatewayTTS;

    /**
     * Fish Speech 本地/远程 TTS
     */
    public FishSpeech fishSpeech;

    /**
     * GPT-SoVITS V2
     */
    public GPT_SOVITS_V2 gptSovitsV2;

    /**
     * GPT-SoVITS V3
     */
    public GPT_SOVITS_V3 gptSovitsV3;

    /**
     * Minimax 流式 TTS
     */
    public MinimaxTTSHTTPStream minimaxTTSHTTPStream;

    /**
     * 阿里云标准 TTS
     */
    public AliyunTTS aliyunTTS;

    /**
     * 阿里云 CosyVoice 流式 TTS
     */
    public AliyunStreamTTS aliyunStreamTTS;

    /**
     * 腾讯云标准 TTS
     */
    public TencentTTS tencentTTS;

    /**
     * 302.AI 语音服务
     */
    public TTS302AI tts302AI;

    /**
     * 机智云语音服务
     */
    public GizwitsTTS gizwitsTTS;

    /**
     * ACGN 动漫音色 TTS
     */
    public ACGNTTS acgnTTS;

    /**
     * OpenAI 官方 TTS
     */
    public OpenAITTS openAITTS;

    /**
     * 自定义 TTS 接口 (如 Kokoro)
     */
    public CustomTTS customTTS;

    /**
     * 灵机 AI TTS
     */
    public LinkeraiTTS linkeraiTTS;

    /**
     * 百度飞桨 PaddleSpeech
     */
    public PaddleSpeechTTS paddleSpeechTTS;

    /**
     * Index-TTS-vLLM 接口
     */
    public IndexStreamTTS indexStreamTTS;

    /**
     * 阿里百炼 CosyVoice 流式
     */
    public AliBLTTS aliBLTTS;

    /**
     * 讯飞流式 TTS (包含超拟人)
     */
    public XunFeiTTS xunFeiTTS;

}