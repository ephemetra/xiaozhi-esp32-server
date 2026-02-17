package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class AliyunBlStreamAsr {
    public String type;
    public String apiKey;
    public String model;
    public String format;
    public Integer sampleRate;
    public Boolean disfluencyRemovalEnabled;
    public Boolean semanticPunctuationEnabled;
    public Integer maxSentenceSilence;
    public Boolean multiThresholdModeEnabled;
    public Boolean punctuationPredictionEnabled;
    public Boolean inverseTextNormalizationEnabled;
    public String outputDir;
}