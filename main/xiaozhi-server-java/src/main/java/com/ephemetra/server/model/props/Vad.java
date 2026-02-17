package com.ephemetra.server.model.props;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Vad {

    /**
     * SileroVAD 模型配置
     */
    @JsonProperty("VAD_SileroVAD")
    public SileroVAD sileroVAD;

}