package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class GeminiLLM {
    public String type;
    public String apiKey;
    public String modelName;
    public String httpProxy;
    public String httpsProxy;
}