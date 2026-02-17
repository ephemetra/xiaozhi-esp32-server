package com.ephemetra.server.model.props;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SileroVAD {
    public String type;
    public Double threshold;
    public Double thresholdLow;
    public String modelDir;
    public Integer minSilenceDurationMs;
}