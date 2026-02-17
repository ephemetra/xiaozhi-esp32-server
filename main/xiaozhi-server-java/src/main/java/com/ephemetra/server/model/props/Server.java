package com.ephemetra.server.model.props;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Server {
    /**
     * 服务器监听地址和端口
     */
    public String ip = "0.0.0.0";
    /**
     * WebSocket 端口
     */
    public int wsPort = 8000;
    /**
     * HTTP 服务端口
     */
    public int httpPort = 8003;
    /**
     * OTA 接口向设备发送的 websocket 地址
     */
    public String websocket;
    /**
     * 视觉分析接口地址
     */
    public String visionExplain;
    /**
     * 时区偏移量
     */
    public String timezoneOffset = "+8";
    /**
     * 认证配置
     */
    public Auth auth = new Auth();
    /**
     * MQTT 网关配置 (host:port)
     */
    public String mqttGateway;
    /**
     * MQTT 签名密钥
     */
    public String mqttSignatureKey;
    /**
     * UDP 网关配置
     */
    public String udpGateway;

    /**
     * 用于jwt认证，比如视觉分析接口的jwt认证、ota接口的token生成与websocket认证
     */
    public String authKey;

    /**
     * 其他配置
     */
    private Integer smsMaxSendCount;
    public String publicKey;
    public String privateKey;
    public String secret;
    public String frontedUrl;
    private String beianGaNum;
    private Boolean allowUserRegister;
    private Boolean enableMobileRegister;
    private String mqttManagerApi;
    private String name;
    private String mcpEndpoint;
    private String voicePrint;
    private String ota;
    private String beianIcpNum;
    private Double voiceprintSimilarityThreshold;

    public Server() {
    }

    public Server(String ip, Integer wsPort, Integer httpPort, String visionExplain, String authKey) {
        this.ip = ip;
        this.wsPort = wsPort;
        this.httpPort = httpPort;
        this.visionExplain = visionExplain;
        this.authKey = authKey;
    }


}