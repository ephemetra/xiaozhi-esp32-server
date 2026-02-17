package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class XunfeiSparkLLM {
    public String type;
    public String baseUrl;
    public String modelName;
    public String apiKey;
}