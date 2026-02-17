package com.ephemetra.server.model.props;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AudioParams {
    public String format = "opus";
    public int sampleRate = 16000;
    public int channels = 1;
    public int frameDuration = 60;
}