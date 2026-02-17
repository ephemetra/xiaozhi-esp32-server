package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class OllamaLLM {
    public String type;
    public String modelName;
    public String baseUrl;
}