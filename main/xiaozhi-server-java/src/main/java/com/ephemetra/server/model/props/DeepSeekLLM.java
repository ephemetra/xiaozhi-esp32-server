package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class DeepSeekLLM {
    public String type;
    public String modelName;
    public String url;
    public String apiKey;
}
