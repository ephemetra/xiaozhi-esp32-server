package com.ephemetra.server.model.props;

import lombok.Data;

import java.util.List;

@Data
public class GPT_SOVITS_V2 {
    public String type;
    public String url;
    public String outputDir;
    public String textLang;
    public String refAudioPath;
    public String promptText;
    public String promptLang;
    public Integer topK;
    public Double topP;
    public Double temperature;
    public String textSplitMethod;
    public Integer batchSize;
    public Double batchThreshold;
    public Boolean splitBucket;
    public Boolean returnFragment;
    public Double speedFactor;
    public Boolean streamingMode;
    public Integer seed;
    public Boolean parallelInfer;
    public Double repetitionPenalty;
    public List<String> auxRefAudioPaths;
}