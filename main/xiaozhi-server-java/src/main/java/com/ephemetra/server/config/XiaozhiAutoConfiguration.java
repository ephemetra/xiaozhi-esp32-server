package com.ephemetra.server.config;

import com.ephemetra.server.core.providers.asr.*;
import com.ephemetra.server.core.providers.intent.IntentBaseProvider;
import com.ephemetra.server.core.providers.llm.LLMBaseProvider;
import com.ephemetra.server.core.providers.memory.MemoryBaseProvider;
import com.ephemetra.server.core.providers.tts.TTSBaseProvider;
import com.ephemetra.server.core.providers.vad.SileroVADBaseProvider;
import com.ephemetra.server.core.providers.vad.VADBaseProvider;
import com.ephemetra.server.core.providers.vllm.VLLMBaseProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 项目模块
 */
@Slf4j
@AutoConfiguration
@EnableConfigurationProperties(XiaozhiConfig.class)
public class XiaozhiAutoConfiguration {

    /*
     * =======================================================================
     * 语音活动检测模块
     * =======================================================================
     */

    @Bean
    @ConditionalOnProperty(name = "selected_module.VAD", havingValue = "SileroVAD")
    public VADBaseProvider sileroVAD(XiaozhiConfig config) {
        return new SileroVADBaseProvider(config);
    }

    /*
     * =======================================================================
     * 语音识别模块
     * =======================================================================
     */

    @Bean
    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "FunASR")
    public ASRBaseProvider funASR(XiaozhiConfig config) {
        return new FunASRBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "FunASRServer")
    public ASRBaseProvider funASRServer(XiaozhiConfig config) {
        return new FunASRServerBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "SherpaASR")
    public ASRBaseProvider sherpaASR(XiaozhiConfig config) {
        return new SherpaASRBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "SherpaParaformerASR")
    public ASRBaseProvider sherpaParaformerASR(XiaozhiConfig config) {
        return new SherpaParaformerASRBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "DoubaoASR")
    public ASRBaseProvider doubaoASR(XiaozhiConfig config) {
        return new DoubaoASRBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "DoubaoStreamASR")
    public ASRBaseProvider doubaoStreamASR(XiaozhiConfig config) {
        return new DoubaoStreamASRBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "TencentASR")
    public ASRBaseProvider tencentASR(XiaozhiConfig config) {
        return new TencentASRBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "AliyunASR")
    public ASRBaseProvider aliyunASR(XiaozhiConfig config) {
        return new AliyunASRBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "AliyunStreamASR")
    public ASRBaseProvider aliyunStreamASR(XiaozhiConfig config) {
        return new AliyunStreamASRBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "BaiduASR")
    public ASRBaseProvider baiduASR(XiaozhiConfig config) {
        return new BaiduASRBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "OpenaiASR")
    public ASRBaseProvider openaiASR(XiaozhiConfig config) {
        return new OpenaiASRBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "GroqASR")
    public ASRBaseProvider groqASR(XiaozhiConfig config) {
        return new GroqASRBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "VoskASR")
    public ASRBaseProvider voskASR(XiaozhiConfig config) {
        return new VoskASRBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "Qwen3ASRFlash")
    public ASRBaseProvider qwen3ASRFlash(XiaozhiConfig config) {
        return new Qwen3ASRFlashBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "XunfeiStreamASR")
    public ASRBaseProvider xunfeiStreamASR(XiaozhiConfig config) {
        return new XunfeiStreamASRBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "AliyunBLStreamASR")
    public ASRBaseProvider aliyunBLStreamASR(XiaozhiConfig config) {
        return new AliyunBLStreamASRBaseProvider(config);
    }

    /*
     * =======================================================================
     * 大模型模块
     * =======================================================================
     */

    @Bean
    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "AliLLM")
    public LLMBaseProvider aliLLM(XiaozhiConfig config) {
        return new AliLLMBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "AliAppLLM")
    public LLMBaseProvider aliAppLLM(XiaozhiConfig config) {
        return new AliAppLLMBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "DoubaoLLM")
    public LLMBaseProvider doubaoLLM(XiaozhiConfig config) {
        return new DoubaoLLMBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "DeepSeekLLM")
    public LLMBaseProvider deepSeekLLM(XiaozhiConfig config) {
        return new DeepSeekLLMBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "ChatGLMLLM")
    public LLMBaseProvider chatGLMLLM(XiaozhiConfig config) {
        return new ChatGLMLLMBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "OllamaLLM")
    public LLMBaseProvider ollamaLLM(XiaozhiConfig config) {
        return new OllamaLLMBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "DifyLLM")
    public LLMBaseProvider difyLLM(XiaozhiConfig config) {
        return new DifyLLMBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "GeminiLLM")
    public LLMBaseProvider geminiLLM(XiaozhiConfig config) {
        return new GeminiLLMBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "CozeLLM")
    public LLMBaseProvider cozeLLM(XiaozhiConfig config) {
        return new CozeLLMBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "VolcesAiGatewayLLM")
    public LLMBaseProvider volcesAiGatewayLLM(XiaozhiConfig config) {
        return new VolcesAiGatewayLLMBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "LMStudioLLM")
    public LLMBaseProvider lmStudioLLM(XiaozhiConfig config) {
        return new LMStudioLLMBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "HomeAssistant")
    public LLMBaseProvider homeAssistantLLM(XiaozhiConfig config) {
        return new HomeAssistantBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "FastgptLLM")
    public LLMBaseProvider fastgptLLM(XiaozhiConfig config) {
        return new FastgptLLMBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "XinferenceLLM")
    public LLMBaseProvider xinferenceLLM(XiaozhiConfig config) {
        return new XinferenceLLMBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "XinferenceSmallLLM")
    public LLMBaseProvider xinferenceSmallLLM(XiaozhiConfig config) {
        return new XinferenceSmallLLMBaseProvider(config);
    }

    /*
     * =======================================================================
     * 视觉语言大模型模块
     * =======================================================================
     */

    @Bean
    @ConditionalOnProperty(name = "selected_module.VLLM", havingValue = "ChatGLMVLLM")
    public VLLMBaseProvider chatGLMVLLM(XiaozhiConfig config) {
        return new ChatGLMVLLMBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.VLLM", havingValue = "QwenVLVLLM")
    public VLLMBaseProvider qwenVLVLLM(XiaozhiConfig config) {
        return new QwenVLVLLMBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.VLLM", havingValue = "XunfeiSparkLLM")
    public VLLMBaseProvider xunfeiSparkLLM(XiaozhiConfig config) {
        return new XunfeiSparkLLMBaseProvider(config);
    }

    /*
     * =======================================================================
     * TTS模块
     * =======================================================================
     */

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "EdgeTTS")
    public TTSBaseProvider edgeTTS(XiaozhiConfig config) {
        return new EdgeTTSBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "DoubaoTTS")
    public TTSBaseProvider doubaoTTS(XiaozhiConfig config) {
        return new DoubaoTTSBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "HuoshanDoubleStreamTTS")
    public TTSBaseProvider huoshanDoubleStreamTTS(XiaozhiConfig config) {
        return new HuoshanDoubleStreamTTSBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "CosyVoiceSiliconflow")
    public TTSBaseProvider cosyVoiceSiliconflow(XiaozhiConfig config) {
        return new CosyVoiceSiliconflowBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "CozeCnTTS")
    public TTSBaseProvider cozeCnTTS(XiaozhiConfig config) {
        return new CozeCnTTSBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "VolcesAiGatewayTTS")
    public TTSBaseProvider volcesAiGatewayTTS(XiaozhiConfig config) {
        return new VolcesAiGatewayTTSBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "FishSpeech")
    public TTSBaseProvider fishSpeech(XiaozhiConfig config) {
        return new FishSpeechBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "GPT_SOVITS_V2")
    public TTSBaseProvider gptSovitsV2(XiaozhiConfig config) {
        return new GPTSovitsV2BaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "GPT_SOVITS_V3")
    public TTSBaseProvider gptSovitsV3(XiaozhiConfig config) {
        return new GPTSovitsV3BaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "MinimaxTTSHTTPStream")
    public TTSBaseProvider minimaxTTSHTTPStream(XiaozhiConfig config) {
        return new MinimaxTTSHTTPStreamBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "AliyunTTS")
    public TTSBaseProvider aliyunTTS(XiaozhiConfig config) {
        return new AliyunTTSBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "AliyunStreamTTS")
    public TTSBaseProvider aliyunStreamTTS(XiaozhiConfig config) {
        return new AliyunStreamTTSBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "TencentTTS")
    public TTSBaseProvider tencentTTS(XiaozhiConfig config) {
        return new TencentTTSBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "TTS302AI")
    public TTSBaseProvider tts302AI(XiaozhiConfig config) {
        return new TTS302AIBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "GizwitsTTS")
    public TTSBaseProvider gizwitsTTS(XiaozhiConfig config) {
        return new GizwitsTTSBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "ACGNTTS")
    public TTSBaseProvider acgnTTS(XiaozhiConfig config) {
        return new ACGNTTSBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "OpenAITTS")
    public TTSBaseProvider openAITTS(XiaozhiConfig config) {
        return new OpenAITTSBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "CustomTTS")
    public TTSBaseProvider customTTS(XiaozhiConfig config) {
        return new CustomTTSBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "LinkeraiTTS")
    public TTSBaseProvider linkeraiTTS(XiaozhiConfig config) {
        return new LinkeraiTTSBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "PaddleSpeechTTS")
    public TTSBaseProvider paddleSpeechTTS(XiaozhiConfig config) {
        return new PaddleSpeechTTSBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "IndexStreamTTS")
    public TTSBaseProvider indexStreamTTS(XiaozhiConfig config) {
        return new IndexStreamTTSBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "AliBLTTS")
    public TTSBaseProvider aliBLTTS(XiaozhiConfig config) {
        return new AliBLTTSBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "XunFeiTTS")
    public TTSBaseProvider xunFeiTTS(XiaozhiConfig config) {
        return new XunFeiTTSBaseProvider(config);
    }

    /*
     * =======================================================================
     * 记忆模块模块
     * =======================================================================
     */

    @Bean
    @ConditionalOnProperty(name = "selected_module.Memory", havingValue = "mem0ai")
    public MemoryBaseProvider mem0aiMemory(XiaozhiConfig config) {
        return new Mem0aiMemoryBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.Memory", havingValue = "nomem")
    public MemoryBaseProvider noMemory(XiaozhiConfig config) {
        return new NoMemoryBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.Memory", havingValue = "mem_local_short")
    public MemoryBaseProvider memLocalShort(XiaozhiConfig config) {
        return new MemLocalShortBaseProvider(config);
    }

    /*
     * =======================================================================
     * 意图识别模块
     * =======================================================================
     */

    @Bean
    @ConditionalOnProperty(name = "selected_module.Intent", havingValue = "nointent")
    public IntentBaseProvider noIntent(XiaozhiConfig config) {
        return new NoIntentBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.Intent", havingValue = "intent_llm")
    public IntentBaseProvider intentLLM(XiaozhiConfig config) {
        return new IntentLLMBaseProvider(config);
    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.Intent", havingValue = "function_call")
    public IntentBaseProvider functionCallIntent(XiaozhiConfig config) {
        return new FunctionCallIntentBaseProvider(config);
    }
}
