package com.ephemetra.server.config;

import com.ephemetra.server.core.providers.asr.ASRBaseProvider;
import com.ephemetra.server.core.providers.asr.FunASRProvider;
import com.ephemetra.server.core.providers.intent.FunctionCallIntentProvider;
import com.ephemetra.server.core.providers.intent.IntentBaseProvider;
import com.ephemetra.server.core.providers.llm.ChatGLMLLMProvider;
import com.ephemetra.server.core.providers.llm.LLMBaseProvider;
import com.ephemetra.server.core.providers.memory.MemoryBaseProvider;
import com.ephemetra.server.core.providers.memory.NoMemoryProvider;
import com.ephemetra.server.core.providers.tts.EdgeTTSProvider;
import com.ephemetra.server.core.providers.tts.TTSBaseProvider;
import com.ephemetra.server.core.providers.vad.SileroVADProvider;
import com.ephemetra.server.core.providers.vad.VADBaseProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 项目模块
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(MainConfig.class)
public class XiaozhiAutoConfiguration {

    /*
     * =======================================================================
     * 语音活动检测模块
     * =======================================================================
     */

    @Bean
    @ConditionalOnProperty(name = "selected_module.VAD", havingValue = "SileroVAD")
    public VADBaseProvider sileroVAD(MainConfig config) {
        return new SileroVADProvider(config);
    }

    /*
     * =======================================================================
     * 语音识别模块
     * =======================================================================
     */

    @Bean
    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "FunASR")
    public ASRBaseProvider funASR(MainConfig config) {
        return new FunASRProvider(config);
    }

//    @Bean
//    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "FunASRServer")
//    public ASRBaseProvider funASRServer(MainConfig config) {
//        return new FunASRServerProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "SherpaASR")
//    public ASRBaseProvider sherpaASR(MainConfig config) {
//        return new SherpaASRProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "SherpaParaformerASR")
//    public ASRBaseProvider sherpaParaformerASR(MainConfig config) {
//        return new SherpaParaformerASRProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "DoubaoASR")
//    public ASRBaseProvider doubaoASR(MainConfig config) {
//        return new DoubaoASRProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "DoubaoStreamASR")
//    public ASRBaseProvider doubaoStreamASR(MainConfig config) {
//        return new DoubaoStreamASRProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "TencentASR")
//    public ASRBaseProvider tencentASR(MainConfig config) {
//        return new TencentASRProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "AliyunASR")
//    public ASRBaseProvider aliyunASR(MainConfig config) {
//        return new AliyunASRProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "AliyunStreamASR")
//    public ASRBaseProvider aliyunStreamASR(MainConfig config) {
//        return new AliyunStreamASRProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "BaiduASR")
//    public ASRBaseProvider baiduASR(MainConfig config) {
//        return new BaiduASRProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "OpenaiASR")
//    public ASRBaseProvider openaiASR(MainConfig config) {
//        return new OpenaiASRProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "GroqASR")
//    public ASRBaseProvider groqASR(MainConfig config) {
//        return new GroqASRProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "VoskASR")
//    public ASRBaseProvider voskASR(MainConfig config) {
//        return new VoskASRProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "Qwen3ASRFlash")
//    public ASRBaseProvider qwen3ASRFlash(MainConfig config) {
//        return new Qwen3ASRFlashProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "XunfeiStreamASR")
//    public ASRBaseProvider xunfeiStreamASR(MainConfig config) {
//        return new XunfeiStreamASRProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.ASR", havingValue = "AliyunBLStreamASR")
//    public ASRBaseProvider aliyunBLStreamASR(MainConfig config) {
//        return new AliyunBLStreamASRProvider(config);
//    }

    /*
     * =======================================================================
     * 大模型模块
     * =======================================================================
     */

//    @Bean
//    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "AliLLM")
//    public LLMBaseProvider aliLLM(MainConfig config) {
//        return new AliLLMProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "AliAppLLM")
//    public LLMBaseProvider aliAppLLM(MainConfig config) {
//        return new AliAppLLMProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "DoubaoLLM")
//    public LLMBaseProvider doubaoLLM(MainConfig config) {
//        return new DoubaoLLMProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "DeepSeekLLM")
//    public LLMBaseProvider deepSeekLLM(MainConfig config) {
//        return new DeepSeekLLMProvider(config);
//    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "ChatGLMLLM")
    public LLMBaseProvider chatGLMLLM(MainConfig config) {
        return new ChatGLMLLMProvider(config);
    }

//    @Bean
//    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "OllamaLLM")
//    public LLMBaseProvider ollamaLLM(MainConfig config) {
//        return new OllamaLLMProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "DifyLLM")
//    public LLMBaseProvider difyLLM(MainConfig config) {
//        return new DifyLLMProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "GeminiLLM")
//    public LLMBaseProvider geminiLLM(MainConfig config) {
//        return new GeminiLLMProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "CozeLLM")
//    public LLMBaseProvider cozeLLM(MainConfig config) {
//        return new CozeLLMProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "VolcesAiGatewayLLM")
//    public LLMBaseProvider volcesAiGatewayLLM(MainConfig config) {
//        return new VolcesAiGatewayLLMProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "LMStudioLLM")
//    public LLMBaseProvider lmStudioLLM(MainConfig config) {
//        return new LMStudioLLMProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "HomeAssistant")
//    public LLMBaseProvider homeAssistantLLM(MainConfig config) {
//        return new HomeAssistantProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "FastgptLLM")
//    public LLMBaseProvider fastgptLLM(MainConfig config) {
//        return new FastgptLLMProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "XinferenceLLM")
//    public LLMBaseProvider xinferenceLLM(MainConfig config) {
//        return new XinferenceLLMProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.LLM", havingValue = "XinferenceSmallLLM")
//    public LLMBaseProvider xinferenceSmallLLM(MainConfig config) {
//        return new XinferenceSmallLLMProvider(config);
//    }

    /*
     * =======================================================================
     * 视觉语言大模型模块
     * =======================================================================
     */

//    @Bean
//    @ConditionalOnProperty(name = "selected_module.VLLM", havingValue = "ChatGLMVLLM")
//    public VLLMBaseProvider chatGLMVLLM(MainConfig config) {
//        return new ChatGLMVLLMProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.VLLM", havingValue = "QwenVLVLLM")
//    public VLLMBaseProvider qwenVLVLLM(MainConfig config) {
//        return new QwenVLVLLMProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.VLLM", havingValue = "XunfeiSparkLLM")
//    public VLLMBaseProvider xunfeiSparkLLM(MainConfig config) {
//        return new XunfeiSparkLLMProvider(config);
//    }

    /*
     * =======================================================================
     * TTS模块
     * =======================================================================
     */

    @Bean
    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "EdgeTTS")
    public TTSBaseProvider edgeTTS(MainConfig config) {
        return new EdgeTTSProvider(config);
    }

//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "DoubaoTTS")
//    public TTSBaseProvider doubaoTTS(MainConfig config) {
//        return new DoubaoTTSProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "HuoshanDoubleStreamTTS")
//    public TTSBaseProvider huoshanDoubleStreamTTS(MainConfig config) {
//        return new HuoshanDoubleStreamTTSProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "CosyVoiceSiliconflow")
//    public TTSBaseProvider cosyVoiceSiliconflow(MainConfig config) {
//        return new CosyVoiceSiliconflowProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "CozeCnTTS")
//    public TTSBaseProvider cozeCnTTS(MainConfig config) {
//        return new CozeCnTTSProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "VolcesAiGatewayTTS")
//    public TTSBaseProvider volcesAiGatewayTTS(MainConfig config) {
//        return new VolcesAiGatewayTTSProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "FishSpeech")
//    public TTSBaseProvider fishSpeech(MainConfig config) {
//        return new FishSpeechProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "GPT_SOVITS_V2")
//    public TTSBaseProvider gptSovitsV2(MainConfig config) {
//        return new GPTSovitsV2Provider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "GPT_SOVITS_V3")
//    public TTSBaseProvider gptSovitsV3(MainConfig config) {
//        return new GPTSovitsV3Provider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "MinimaxTTSHTTPStream")
//    public TTSBaseProvider minimaxTTSHTTPStream(MainConfig config) {
//        return new MinimaxTTSHTTPStreamProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "AliyunTTS")
//    public TTSBaseProvider aliyunTTS(MainConfig config) {
//        return new AliyunTTSProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "AliyunStreamTTS")
//    public TTSBaseProvider aliyunStreamTTS(MainConfig config) {
//        return new AliyunStreamTTSProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "TencentTTS")
//    public TTSBaseProvider tencentTTS(MainConfig config) {
//        return new TencentTTSProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "TTS302AI")
//    public TTSBaseProvider tts302AI(MainConfig config) {
//        return new TTS302AIProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "GizwitsTTS")
//    public TTSBaseProvider gizwitsTTS(MainConfig config) {
//        return new GizwitsTTSProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "ACGNTTS")
//    public TTSBaseProvider acgnTTS(MainConfig config) {
//        return new ACGNTTSProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "OpenAITTS")
//    public TTSBaseProvider openAITTS(MainConfig config) {
//        return new OpenAITTSProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "CustomTTS")
//    public TTSBaseProvider customTTS(MainConfig config) {
//        return new CustomTTSProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "LinkeraiTTS")
//    public TTSBaseProvider linkeraiTTS(MainConfig config) {
//        return new LinkeraiTTSProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "PaddleSpeechTTS")
//    public TTSBaseProvider paddleSpeechTTS(MainConfig config) {
//        return new PaddleSpeechTTSProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "IndexStreamTTS")
//    public TTSBaseProvider indexStreamTTS(MainConfig config) {
//        return new IndexStreamTTSProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "AliBLTTS")
//    public TTSBaseProvider aliBLTTS(MainConfig config) {
//        return new AliBLTTSProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.TTS", havingValue = "XunFeiTTS")
//    public TTSBaseProvider xunFeiTTS(MainConfig config) {
//        return new XunFeiTTSProvider(config);
//    }

    /*
     * =======================================================================
     * 记忆模块模块
     * =======================================================================
     */

//    @Bean
//    @ConditionalOnProperty(name = "selected_module.Memory", havingValue = "mem0ai")
//    public MemoryBaseProvider mem0aiMemory(MainConfig config) {
//        return new Mem0aiMemoryProvider(config);
//    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.Memory", havingValue = "nomem")
    public MemoryBaseProvider noMemory(MainConfig config) {
        return new NoMemoryProvider(config);
    }

//    @Bean
//    @ConditionalOnProperty(name = "selected_module.Memory", havingValue = "mem_local_short")
//    public MemoryBaseProvider memLocalShort(MainConfig config) {
//        return new MemLocalShortProvider(config);
//    }

    /*
     * =======================================================================
     * 意图识别模块
     * =======================================================================
     */

//    @Bean
//    @ConditionalOnProperty(name = "selected_module.Intent", havingValue = "nointent")
//    public IntentBaseProvider noIntent(MainConfig config) {
//        return new NoIntentProvider(config);
//    }
//
//    @Bean
//    @ConditionalOnProperty(name = "selected_module.Intent", havingValue = "intent_llm")
//    public IntentBaseProvider intentLLM(MainConfig config) {
//        return new IntentLLMProvider(config);
//    }

    @Bean
    @ConditionalOnProperty(name = "selected_module.Intent", havingValue = "function_call")
    public IntentBaseProvider functionCallIntent(MainConfig config) {
        return new FunctionCallIntentProvider(config);
    }
}
