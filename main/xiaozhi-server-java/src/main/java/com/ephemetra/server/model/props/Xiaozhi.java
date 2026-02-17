package com.ephemetra.server.model.props;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Xiaozhi {
    public String type = "hello";
    public int version = 1;
    public String transport = "websocket";
    public AudioParams audioParams = new AudioParams();
}