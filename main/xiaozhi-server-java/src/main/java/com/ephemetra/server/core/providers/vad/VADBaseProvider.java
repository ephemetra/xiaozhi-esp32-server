package com.ephemetra.server.core.providers.vad;

import com.ephemetra.server.config.MainConfig;
import com.ephemetra.server.core.ConnectionHandler;
import com.ephemetra.server.utils.OpusNativeDecoder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class VADBaseProvider {

    private final MainConfig config;

    public OpusNativeDecoder decoder;

    /**
     * 检测音频数据中的语音活动
     */
    public abstract boolean isVad(ConnectionHandler conn, byte[] audio);
}
