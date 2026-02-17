package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class GetWeather {
    public String apiHost;
    public String apiKey;
    public String defaultLocation;
}