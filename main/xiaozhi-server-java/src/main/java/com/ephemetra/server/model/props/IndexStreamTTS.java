package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class IndexStreamTTS {
    public String type;
    public String apiUrl;
    public String audioFormat;
    public String voice;
    public String outputDir;
}