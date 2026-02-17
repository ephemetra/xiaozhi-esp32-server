package com.ephemetra.server;

import cn.hutool.core.thread.ThreadUtil;
import com.ephemetra.server.config.MainConfig;
import com.ephemetra.server.core.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.UUID;

import static com.ephemetra.server.config.ConfigLoader.loadConfig;
import static com.ephemetra.server.utils.NetworkUtils.getLocalIp;

@Slf4j
@EnableFeignClients
@SpringBootApplication
public class XiaozhiJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaozhiJavaApplication.class, args);
//        checkFFmpegInstalled();
        MainConfig config = loadConfig();
        // 优先级：配置文件server.auth_key > manager-api.secret > 自动生成
        String authKey = config.server.authKey;
        // 验证auth_key，无效则尝试使用manager-api.secret
        if (authKey == null || authKey.contains("你")) {
            authKey = config.managerApi.secret;
            // 验证secret，无效则生成随机密钥
            if (authKey == null || authKey.contains("你")) {
                authKey = UUID.randomUUID().toString();
            }
        }
        config.server.authKey = authKey;
        // 启动 WebSocket 服务器
        WebSocketServer wsServer = new WebSocketServer(config);
        ThreadUtil.execute(wsServer::start);

        boolean readConfigFromApi = config.readConfigFromApi;
        int port = config.server.httpPort;
        String localIp = getLocalIp();
        if (!readConfigFromApi) {
            log.info("OTA接口是\\t\\thttp://{}:{}/xiaozhi/ota/", localIp, port);
        }
        log.info("视觉分析接口是\thttp://{}:{}/mcp/vision/explain", localIp, port);
        String mcpEndpoint = config.mcpEndpoint;
        if (mcpEndpoint != null && !mcpEndpoint.contains("你")) {
            // 校验MCP接入点格式
            if (validateMcpEndpoint(mcpEndpoint)) {
                log.info("mcp接入点是\\t{}", mcpEndpoint);
                // 将mcp计入点地址转成调用点
                mcpEndpoint = mcpEndpoint.replace("/mcp/", "/call/");
                config.mcpEndpoint = mcpEndpoint;
            } else {
                log.info("mcp接入点不符合规范");
                config.mcpEndpoint = "你的接入点 websocket地址";
            }
        }
        int websocketPort = config.server.wsPort;
        log.info("Websocket地址是\\tws://{}:{}/xiaozhi/v1/", localIp, websocketPort);
        log.info("=======上面的地址是websocket协议地址，请勿用浏览器访问=======");
        log.info("如想测试websocket请用谷歌浏览器打开test目录下的test_page.html");
        log.info("=============================================================\n");
    }

    /**
     * 校验MCP接入点格式
     */
    public static boolean validateMcpEndpoint(String mcpEndpoint) {
        if (mcpEndpoint == null) {
            return false;
        }
        // 1. 检查是否以ws开头
        if (!mcpEndpoint.startsWith("ws")) {
            return false;
        }
        // 2. 检查是否包含key、call字样
        String lowerEndpoint = mcpEndpoint.toLowerCase();
        if (lowerEndpoint.contains("key") || lowerEndpoint.contains("call")) {
            return false;
        }
        // 3. 检查是否包含/mcp/字样
        if (!mcpEndpoint.contains("/mcp/")) {
            return false;
        }
        return true;
    }

}
