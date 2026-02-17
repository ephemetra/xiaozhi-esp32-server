package com.ephemetra.server.model.props;

import lombok.Data;

import java.util.List;

@Data
public class PlayMusic {
    public String musicDir;
    public List<String> musicExt; // 对应 [".mp3", ".wav", ".p3"]
    public Integer refreshTime;   // 单位：秒
}