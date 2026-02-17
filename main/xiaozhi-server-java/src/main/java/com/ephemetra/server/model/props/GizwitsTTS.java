package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class GizwitsTTS {
    public String type;
    public String apiUrl;
    public String authorization;
    public String voice;
    public String outputDir;
    public String accessToken;
}
