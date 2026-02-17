package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class DifyLLM {
    public String type;
    public String baseUrl;
    public String apiKey;
    public String mode;
}