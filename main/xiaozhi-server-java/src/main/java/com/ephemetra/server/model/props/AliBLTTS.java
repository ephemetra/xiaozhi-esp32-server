package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class AliBLTTS {
    public String type;
    public String apiKey;
    public String model;
    public String voice;
    public String outputDir;
}