package com.ephemetra.server.model.props;

import lombok.Data;

import java.util.List;

@Data
public class VoicePrint {
    public String url;
    public List<String> speakers;
    public Double similarityThreshold;
}