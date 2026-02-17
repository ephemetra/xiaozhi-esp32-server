package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class ManagerApi {
    /**
     * manager-api的地址
     */
    public String url;
    /**
     * manager-api的token
     */
    public String secret;
}