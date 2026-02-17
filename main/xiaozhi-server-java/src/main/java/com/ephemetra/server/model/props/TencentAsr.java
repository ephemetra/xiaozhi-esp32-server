package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class TencentAsr {
    public String type;
    public String appid;
    public String secretId;
    public String secretKey;
    public String outputDir;
}