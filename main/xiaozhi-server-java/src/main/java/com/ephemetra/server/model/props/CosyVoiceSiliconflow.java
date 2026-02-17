package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class CosyVoiceSiliconflow {
    public String type;
    public String model;
    public String voice;
    public String outputDir;
    public String accessToken;
    public String responseFormat;
}