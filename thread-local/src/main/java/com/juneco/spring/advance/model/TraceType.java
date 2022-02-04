package com.juneco.spring.advance.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TraceType {
    IN("in"), OUT("out");

    private final String name;
}
