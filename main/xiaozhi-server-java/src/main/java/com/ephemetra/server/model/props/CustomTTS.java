package com.ephemetra.server.model.props;

import lombok.Data;

import java.util.Map;

@Data
public class CustomTTS {
    public String type;
    public String method;
    public String url;
    public Map<String, Object> params;
    public Map<String, String> headers;
    public String format;
    public String outputDir;
}