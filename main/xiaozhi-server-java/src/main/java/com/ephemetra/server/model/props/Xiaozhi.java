package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class Xiaozhi {
    public String type = "hello";
    public int version = 1;
    public String transport = "websocket";
    public AudioParams audioParams = new AudioParams();
}