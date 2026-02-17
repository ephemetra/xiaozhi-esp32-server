package com.ephemetra.server.config;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.ephemetra.server.client.ManageApiClient;
import com.ephemetra.server.model.props.Auth;
import com.ephemetra.server.model.props.Server;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ConfigLoader {

    private static ManageApiClient manageApiClient;
    private static MainConfig config;

    public ConfigLoader(ManageApiClient manageApiClient) {
        this.manageApiClient = manageApiClient;
    }

    /**
     * 加载配置文件
     */
    public static MainConfig loadConfig() {
        // 加载本地配置
        MainConfig localConfig = SpringUtil.getBean(MainConfig.class);
        if (StrUtil.isNotBlank(localConfig.managerApi.url)) {
            try {
                config = ThreadUtil.execAsync(() -> getConfigFromApiAsync(localConfig)).get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (StrUtil.isNotBlank(config.managerApi.secret)) {
            config = localConfig;
        }
        // 初始化目录
        ensureDirectories(config);
        return config;
    }

    /**
     * 从manage-api获取配置
     */
    public static MainConfig getConfigFromApiAsync(MainConfig localConfig) {
        // 获取服务器配置
        MainConfig configData = manageApiClient.getServerConfig();
        if (configData == null) {
            throw new RuntimeException("Failed to fetch server config from API");
        }
        configData.readConfigFromApi = true;
        configData.managerApi.url = localConfig.managerApi.url;
        configData.managerApi.secret = localConfig.managerApi.secret;
        boolean authEnabled = Optional.ofNullable(configData).map(c -> c.server).map(s -> s.auth).map(a -> a.enabled).orElse(false);
        // server的配置以本地为准
        if (localConfig.server != null) {
            configData.server = new Server(localConfig.server.ip, localConfig.server.wsPort, localConfig.server.httpPort, localConfig.server.visionExplain, localConfig.server.authKey);
        }
        configData.server.auth = new Auth(authEnabled);
        // 如果服务器没有prompt_template，则从本地配置读取
        if (configData.promptTemplate == null) {
            configData.promptTemplate = localConfig.promptTemplate;
        }
        return configData;
    }

    /**
     * 确保所有配置路径存在
     */
    private static void ensureDirectories(MainConfig config) {

    }
}
