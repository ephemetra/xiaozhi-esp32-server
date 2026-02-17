package com.ephemetra.server.model.props;

import lombok.Data;

import java.util.Map;

@Data
public class FastgptLLM {
    public String type;
    public String baseUrl;
    public String apiKey;
    public Map<String, String> variables;
}