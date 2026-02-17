package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class CozeLLM {
    public String type;
    public String botId;
    public String userId;
    public String personalAccessToken;
}