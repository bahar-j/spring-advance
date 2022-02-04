package com.juneco.spring.advance.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Trace {
    private int depth;
    private String traceId;
    LocalDateTime initialDtt;

    public Trace(int depth, String traceId, LocalDateTime initialDtt) {
        this.depth = depth;
        this.traceId = traceId;
        this.initialDtt = initialDtt;
    }
}
