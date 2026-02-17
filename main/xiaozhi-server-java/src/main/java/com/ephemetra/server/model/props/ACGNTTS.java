package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class ACGNTTS {
    public String type;
    public String token;
    public Integer voiceId;
    public Double speedFactor;
    public Double pitchFactor;
    public Double volumeChangeDB;
    public String toLang;
    public String url;
    public String format;
    public String outputDir;
    public Integer emotion;
}
