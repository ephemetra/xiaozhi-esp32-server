package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class PaddleSpeechTTS {
    public String type;
    public String protocol;
    public String url;
    public Integer spkId;
    public Integer sampleRate;
    public Double speed;
    public Double volume;
    public String savePath;
}