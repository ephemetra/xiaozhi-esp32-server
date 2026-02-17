package com.ephemetra.server.model.props;

import lombok.Data;

import java.util.Map;

@Data
public class ContextProvider {
    public String url;
    public Map<String, String> headers;
}