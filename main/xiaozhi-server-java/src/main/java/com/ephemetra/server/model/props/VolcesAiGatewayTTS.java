package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class VolcesAiGatewayTTS {
    public String type;
    public String apiKey;
    public String apiUrl;
    public String model;
    public String voice;
    public Integer speed;
    public String outputDir;
}
