package com.ephemetra.server.config;

import com.ephemetra.server.model.props.*;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * 小智服务器统一配置类
 */
@Data

@ConfigurationProperties
public class XiaozhiConfig {

    /*********************************以下是服务器基本运行配置***************************************/

    /**
     * manager-api信息
     */
    public ManagerApi managerApi;

    /**
     * 服务器基本运行配置
     */
    public Server server = new Server();

    /**
     * 使用完声音文件后是否删除
     */
    public boolean deleteAudio = true;

    /**
     * 没有语音输入多久后断开连接(秒)，默认120秒
     */
    public int closeConnectionNoVoiceTime = 120;

    /**
     * TTS请求超时时间(秒)
     */
    public int ttsTimeout = 10;

    /**
     * 是否开启唤醒词加速
     */
    public boolean enableWakeupWordsResponseCache = true;

    /**
     * 开场是否回复唤醒词
     */
    public boolean enableGreeting = true;

    /**
     * 说完话是否开启提示音
     */
    public boolean enableStopTtsNotify = false;

    /**
     * 说完话提示音的音效地址
     */
    public String stopTtsNotifyVoice = "config/assets/tts_notify.mp3";

    /**
     * 是否启用WebSocket心跳保活机制
     */
    public boolean enableWebsocketPing = false;

    /**
     * TTS音频发送延迟配置 (0: 精确时间, >0: 固定延迟毫秒)
     */
    public int ttsAudioSendDelay = 0;

    /**
     * 退出指令列表
     */
    public List<String> exitCommands;

    /**
     * 小智协议相关配置
     */
    public Xiaozhi xiaozhi = new Xiaozhi();

    /**
     * 模块测试配置
     */
    public ModuleTest moduleTest = new ModuleTest();

    /**
     * 唤醒词，用于识别唤醒词还是讲话内容
     */
    public List<String> wakeupWords;

    /**
     * MCP接入点地址
     */
    public String mcpEndpoint;

    /**
     * 上下文源配置
     */
    public List<ContextProvider> contextProviders;

    /**
     * 插件的基础配置
     */
    public Plugins plugins;

    /**
     * 声纹识别配置
     */
    public VoicePrint voiceprint;

    /**
     * 从api获取文件文件
     */
    public boolean readConfigFromApi = false;

    /*********************************以下是角色模型配置***************************************/

    /**
     * 角色设定提示词
     */
    public String prompt;

    /**
     * 默认系统提示词模板文件
     */
    public String promptTemplate = "agent-base-prompt.txt";

    /**
     * 结束语提示词
     */
    public EndPrompt endPrompt;

    /**
     * 具体处理时选择的模块
     */
    public SelectedModule selectedModule;

    /**
     * 意图识别
     */
    public Intent intent;

    /**
     * 记忆模块
     */
    public Memory memory;

    /**
     * 语音识别配置
     */
    public Asr asr;

    /**
     * 语音活动检测
     */
    public Vad vad;

    /**
     * 大语言模型
     */
    public Llm llm;

    /**
     * 视觉语言大模型配置
     */
    public Vllm vllm;

    /**
     * 语音合成配置
     */
    public Tts tts;
}
