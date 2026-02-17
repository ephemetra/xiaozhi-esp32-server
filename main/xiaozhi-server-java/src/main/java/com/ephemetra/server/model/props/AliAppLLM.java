package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class AliAppLLM {
    public String type;
    public String baseUrl;
    public String appId;
    public String apiKey;
    public Boolean isNoPrompt;
    public String aliMemoryId;
}

