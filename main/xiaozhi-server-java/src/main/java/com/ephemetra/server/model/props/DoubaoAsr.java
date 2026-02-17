package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class DoubaoAsr {
    public String type;
    public String appid;
    public String accessToken;
    public String cluster;
    public String boostingTableName;
    public String correctTableName;
    public String outputDir;
}