package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class CozeCnTTS {
    public String type;
    public String voice;
    public String outputDir;
    public String accessToken;
    public String responseFormat;
}