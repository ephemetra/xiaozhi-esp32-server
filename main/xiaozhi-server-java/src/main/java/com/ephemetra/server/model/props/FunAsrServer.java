package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class FunAsrServer {
    public String type;
    public String host;
    public Integer port;
    public Boolean isSsl;
    public String apiKey;
    public String outputDir;
}