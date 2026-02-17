package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class EdgeTTS {
    public String type;
    public String voice;
    public String outputDir;
}