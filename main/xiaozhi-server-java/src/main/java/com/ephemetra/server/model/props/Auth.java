package com.ephemetra.server.model.props;

import lombok.Data;

import java.util.List;

@Data
public class Auth {
    /**
     * 是否启用认证
     */
    public boolean enabled = false;
    /**
     * 白名单设备ID列表
     */
    public List<String> allowedDevices;

    public Auth() {
    }

    public Auth(boolean enabled) {
        this.enabled = enabled;
    }
}