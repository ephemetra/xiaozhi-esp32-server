package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class Qwen3AsrFlash {
    public String type;
    public String apiKey;
    public String baseUrl;
    public String modelName;
    public String outputDir;
    public Boolean enableLid;
    public Boolean enableItn;
    public String context;
}