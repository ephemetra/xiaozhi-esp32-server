package com.ephemetra.server.core.providers.vad;

import com.ephemetra.server.config.XiaozhiConfig;
import com.ephemetra.server.core.ConnectionHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class VADBaseProvider {

    private final XiaozhiConfig config;

    /**
     * 检测音频数据中的语音活动
     */
    public abstract boolean isVad(ConnectionHandler conn, byte[] audio);
}
