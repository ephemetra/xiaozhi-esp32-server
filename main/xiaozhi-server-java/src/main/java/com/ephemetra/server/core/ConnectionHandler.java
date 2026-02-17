package com.ephemetra.server.core;

import cn.hutool.core.thread.ThreadUtil;
import com.ephemetra.server.config.MainConfig;
import com.ephemetra.server.model.props.Xiaozhi;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;

import java.net.InetSocketAddress;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Slf4j
public class ConnectionHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private final MainConfig config;

    public HttpHeaders headers;
    public String clientIp;
    public String deviceId;
    private ChannelHandlerContext websocket;
    public boolean connFromMqttGateway;
    public long firstActivityTime;
    public long lastActivityTime;
    public int sampleRate;
    public Xiaozhi welcomeMsg;
    public Future<?> timeoutTask;
    public Boolean readConfigFromApi;
    // 是否需要绑定设备
    public boolean needBind;
    public CompletableFuture bindCompletedEvent = new CompletableFuture<>();

    public ConnectionHandler(MainConfig config) {
        this.config = config;
        this.readConfigFromApi = this.config.readConfigFromApi;
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof WebSocketServerProtocolHandler.HandshakeComplete) {
            WebSocketServerProtocolHandler.HandshakeComplete handshake = (WebSocketServerProtocolHandler.HandshakeComplete) evt;
            // 获取并验证headers
            this.headers = handshake.requestHeaders();
            String realIp = this.headers.get("x-real-ip");
            if (realIp != null) {
                realIp = this.headers.get("x-forwarded-for");
            }
            if (realIp != null) {
                this.clientIp = realIp.split(",")[0].trim();
            } else {
                this.clientIp = ((InetSocketAddress) ctx.channel().remoteAddress()).getAddress().getHostAddress();
            }
            log.info("{} conn - Headers: {}", clientIp, headers);
            this.deviceId = headers.get("device-id");
            // 认证通过,继续处理
            this.websocket = ctx;
            // 检查是否来自MQTT连接
            String requestPath = handshake.requestUri();
            this.connFromMqttGateway = requestPath != null && requestPath.endsWith("from=mqtt_gateway");
            if (this.connFromMqttGateway) {
                log.info("连接来自:MQTT网关");
            }
            // 初始化活动时间戳
            this.firstActivityTime = System.currentTimeMillis();
            this.lastActivityTime = System.currentTimeMillis();
            // 启动超时检查任务
            this.timeoutTask = ThreadUtil.execAsync(() -> checkTimeout());

            this.welcomeMsg = config.getXiaozhi();

            // 从配置中读取采样率
            this.sampleRate = this.welcomeMsg.getAudioParams().getSampleRate();
            log.info("配置输出音频采样率为: {}", this.sampleRate);

            // 在后台初始化配置和组件（完全不阻塞主循环）
            backgroundInitialize();
        }
        super.userEventTriggered(ctx, evt);
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame frame) {
        // 更新最后活跃时间
        this.lastActivityTime = System.currentTimeMillis();

        String text = frame.text();
        // routeMessage(text);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        log.info("客户端断开连接");
        saveAndClose(ctx);
    }

    /**
     * 检查连接超时
     */
    protected void checkTimeout() {

    }

    /**
     * 异步在后台初始化配置和组件
     */
    @Async
    protected void backgroundInitialize() {
        initializePrivateConfigAsync();
        ThreadUtil.execAsync(this::initializeComponents);
    }

    /**
     * 从接口异步获取差异化配置
     */
    protected void initializePrivateConfigAsync() {
        if (!this.readConfigFromApi) {
            this.needBind = false;
            this.bindCompletedEvent.complete(null);
            return;
        }
        long beginTime = System.currentTimeMillis() / 1000;
    }

    protected void initializeComponents() {

    }

    /**
     * 保存记忆并关闭连接
     */
    protected void saveAndClose(ChannelHandlerContext ctx) {

    }
}