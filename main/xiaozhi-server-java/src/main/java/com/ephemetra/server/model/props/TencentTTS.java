package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class TencentTTS {
    public String type;
    public String outputDir;
    public String appid;
    public String secretId;
    public String secretKey;
    public String region;
    public Integer voice;
}