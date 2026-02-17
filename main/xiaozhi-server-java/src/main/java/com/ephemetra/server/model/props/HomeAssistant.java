package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class HomeAssistant {
    public String type;
    public String baseUrl;
    public String agentId;
    public String apiKey;
}
