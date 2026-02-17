package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class XunFeiTTS {
    public String type;
    public String apiUrl;
    public String appId;
    public String apiSecret;
    public String apiKey;
    public String voice;
    public String outputDir;
}