package com.ephemetra.server.model.props;

import lombok.Data;

import java.util.List;

@Data
public class SearchFromRagflow {
    public String description;
    public String baseUrl;
    public String apiKey;
    public List<String> datasetIds;
}