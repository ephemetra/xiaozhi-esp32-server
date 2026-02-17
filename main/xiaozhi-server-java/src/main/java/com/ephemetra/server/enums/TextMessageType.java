package com.ephemetra.server.enums;

import lombok.Getter;

/**
 * 消息类型枚举
 */
@Getter
public enum TextMessageType {
    /**
     * 问候消息
     */
    HELLO("hello"),
    /**
     * 中断消息
     */
    ABORT("abort"),
    /**
     * 监听消息
     */
    LISTEN("listen"),
    /**
     * 物联网消息
     */
    IOT("iot"),
    /**
     * MCP消息
     */
    MCP("mcp"),
    /**
     * 服务消息
     */
    SERVER("server"),
    /**
     * 心跳消息
     */
    PING("ping");

    private final String value;

    TextMessageType(String value) {
        this.value = value;
    }

    /**
     * 根据字符串值获取对应的枚举
     *
     * @param value 字符串值
     * @return 匹配的枚举，若未找到则返回 null
     */
    public static TextMessageType fromValue(String value) {
        for (TextMessageType type : TextMessageType.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }
}
