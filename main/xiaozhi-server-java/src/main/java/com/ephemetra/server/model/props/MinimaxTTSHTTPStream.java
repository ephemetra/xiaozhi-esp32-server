package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class MinimaxTTSHTTPStream {
    public String type;
    public String outputDir;
    public String groupId;
    public String apiKey;
    public String model;
    public String voiceId;
}