package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class VolcesAiGatewayLLM {
    public String type;
    public String baseUrl;
    public String modelName;
    public String apiKey;
}
