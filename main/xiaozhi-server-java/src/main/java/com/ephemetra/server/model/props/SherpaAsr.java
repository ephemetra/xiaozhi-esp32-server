package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class SherpaAsr {
    public String type;
    public String modelDir;
    public String outputDir;
    public String modelType;
}