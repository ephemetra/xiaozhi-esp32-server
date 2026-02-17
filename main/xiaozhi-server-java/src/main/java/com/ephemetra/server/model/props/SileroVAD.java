package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class SileroVAD {
    public String type;
    public Double threshold;
    public Double thresholdLow;
    public String modelDir;
    public Integer minSilenceDurationMs;
}