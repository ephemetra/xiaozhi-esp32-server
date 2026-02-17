package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class BaiduAsr {
    public String type;
    public String appId;
    public String apiKey;
    public String secretKey;
    public Integer devPid;
    public String outputDir;
}