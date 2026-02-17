package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class AliyunTTS {
    public String type;
    public String outputDir;
    public String appkey;
    public String token;
    public String voice;
    public String accessKeyId;
    public String accessKeySecret;
}