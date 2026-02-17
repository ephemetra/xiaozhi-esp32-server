package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class LinkeraiTTS {
    public String type;
    public String apiUrl;
    public String audioFormat;
    public String accessToken;
    public String voice;
    public String outputDir;
}
