package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class AudioParams {
    public String format = "opus";
    public int sampleRate = 16000;
    public int channels = 1;
    public int frameDuration = 60;
}