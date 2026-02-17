package com.ephemetra.server.client;

import com.ephemetra.server.config.MainConfig;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 用于请求manage-api的客户端
 */
public interface ManageApiClient {

    /**
     * 获取服务器基础配置
     */
    @PostMapping("/config/server-base")
    MainConfig getServerConfig();
}
