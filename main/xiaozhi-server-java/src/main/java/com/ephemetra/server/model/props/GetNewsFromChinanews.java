package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class GetNewsFromChinanews {
    public String defaultRssUrl;
    public String societyRssUrl;
    public String worldRssUrl;
    public String financeRssUrl;
}