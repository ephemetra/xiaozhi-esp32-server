package com.ephemetra.server.model.props;

import lombok.Data;

import java.util.List;

@Data
public class FishSpeech {
    public String type;
    public String outputDir;
    public String responseFormat;
    public String referenceId;
    public List<String> referenceAudio;
    public List<String> referenceText;
    public Boolean normalize;
    public Integer maxNewTokens;
    public Integer chunkLength;
    public Double topP;
    public Double repetitionPenalty;
    public Double temperature;
    public Boolean streaming;
    public String useMemoryCache;
    public String seed;
    public Integer channels;
    public Integer rate;
    public String apiKey;
    public String apiUrl;
}