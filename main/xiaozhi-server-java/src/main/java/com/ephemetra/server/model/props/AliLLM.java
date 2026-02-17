package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class AliLLM {
    public String type;
    public String baseUrl;
    public String modelName;
    public String apiKey;
    public Double temperature;
    public Integer maxTokens;
    public Double topP;
    public Integer frequencyPenalty;
}