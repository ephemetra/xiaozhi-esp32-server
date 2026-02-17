package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class HuoshanDoubleStreamTTS {
    public String type;
    public String wsUrl;
    public String appid;
    public String accessToken;
    public String resourceId;
    public String speaker;
    public Boolean enableWsReuse;
    public Integer speechRate;
    public Integer loudnessRate;
    public Integer pitch;
    public String emotion;
    public Integer emotionScale;
}