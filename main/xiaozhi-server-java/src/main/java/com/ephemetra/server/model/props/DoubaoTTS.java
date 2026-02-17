package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class DoubaoTTS {
    public String type;
    public String apiUrl;
    public String voice;
    public String outputDir;
    public String authorization;
    public String appid;
    public String accessToken;
    public String cluster;
    public Double speedRatio;
    public Double volumeRatio;
    public Double pitchRatio;
}