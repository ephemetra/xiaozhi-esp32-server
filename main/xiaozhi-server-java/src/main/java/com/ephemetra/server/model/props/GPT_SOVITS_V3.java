package com.ephemetra.server.model.props;

import lombok.Data;

import java.util.List;

@Data
public class GPT_SOVITS_V3 {
    public String type;
    public String url;
    public String outputDir;
    public String textLanguage;
    public String referWavPath;
    public String promptLanguage;
    public String promptText;
    public Integer topK;
    public Double topP;
    public Double temperature;
    public String cutPunc;
    public Double speed;
    public List<String> inpRefs;
    public Integer sampleSteps;
    public Boolean ifSr;
}