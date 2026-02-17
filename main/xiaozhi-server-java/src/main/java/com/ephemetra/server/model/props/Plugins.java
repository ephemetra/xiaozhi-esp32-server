package com.ephemetra.server.model.props;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Plugins {
    /**
     * 获取天气插件的配置
     */
    public GetWeather getWeather;

    /**
     * ChinaNews新闻插件的配置
     */
    public GetNewsFromChinanews getNewsFromChinanews;

    /**
     * NewsNow新闻插件的配置
     */
    public GetNewsFromNewsnow getNewsFromNewsnow;

    /**
     * HomeAssistant插件的配置
     */
    public HomeAssistant homeAssistant;

    /**
     * Music插件的配置
     */
    public PlayMusic playMusic;

    /**
     * RagFlow插件的配置
     */
    public SearchFromRagflow searchFromRagflow;
}