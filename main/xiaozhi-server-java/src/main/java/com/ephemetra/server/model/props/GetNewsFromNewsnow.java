package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class GetNewsFromNewsnow {
    public String url;
    public String newsSources; // 对应 "澎湃新闻;百度热搜;..."
}