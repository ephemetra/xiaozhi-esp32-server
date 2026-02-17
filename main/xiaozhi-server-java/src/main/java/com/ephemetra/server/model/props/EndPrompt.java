package com.ephemetra.server.model.props;

import lombok.Data;

@Data
public class EndPrompt {
    public boolean enable = true;
    public String prompt;
}
