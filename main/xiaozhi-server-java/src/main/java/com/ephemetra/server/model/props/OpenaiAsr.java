package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class OpenaiAsr {
    public String type;
    public String apiKey;
    public String baseUrl;
    public String modelName;
    public String outputDir;
}
