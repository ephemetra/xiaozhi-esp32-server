package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class AliyunAsr {
    public String type;
    public String appkey;
    public String token;
    public String accessKeyId;
    public String accessKeySecret;
    public String outputDir;
}