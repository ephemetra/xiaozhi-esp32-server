package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class XunfeiStreamAsr {
    public String type;
    public String appId;
    public String apiKey;
    public String apiSecret;
    public String domain;
    public String language;
    public String accent;
    public String outputDir;
}