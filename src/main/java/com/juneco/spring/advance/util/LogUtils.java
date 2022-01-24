package com.juneco.spring.advance.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class LogUtils {

    public static String createTraceId() {
        return UUID.randomUUID().toString().substring(8);
    }

}
