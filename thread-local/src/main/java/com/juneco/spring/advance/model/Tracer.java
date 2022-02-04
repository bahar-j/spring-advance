package com.juneco.spring.advance.model;

import com.juneco.spring.advance.util.LogUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Log4j2
@Component
public class Tracer {
    private final ThreadLocal<Trace> threadLocalTrace = new ThreadLocal<>();
    private static final String IN = "-->";
    private static final String OUT = "<--";

    public void in(String message) {
        updateTraceStatus(TraceType.IN);
        Trace trace = threadLocalTrace.get();
        logMessage(trace, message, TraceType.IN, null);
    }

    public void out(String message, Exception e) {
        updateTraceStatus(TraceType.OUT);
        Trace trace = threadLocalTrace.get();
        logMessage(trace, message, TraceType.OUT, e);
    }

    private void updateTraceStatus(TraceType traceType) {
        Trace trace = threadLocalTrace.get();
        if (trace == null) {
            threadLocalTrace.set(new Trace(0, LogUtils.createTraceId(), LocalDateTime.now()));
        } else {
            if ("in".equals(traceType.getName())) {
                trace.setDepth(trace.getDepth()+1);
            } else if ("out".equals(traceType.getName())) {
                trace.setDepth(trace.getDepth()-1);
            }
            threadLocalTrace.set(trace);
        }
    }

    private void logMessage(Trace trace, String message, TraceType traceType, Exception e) {
        if (trace.getDepth() == 0) {
            if ("in".equals(traceType.getName())) {
                log.info("[{}] {}", trace.getTraceId(), message);
            } else if ("out".equals(traceType.getName())) {
                if (e != null) {
                    log.info("[{}] {} time={}ns {}: 예외 발생!", trace.getTraceId(), message, LocalDateTime.now().minusNanos(trace.getInitialDtt().getNano()), e.toString());
                } else {
                    log.info("[{}] {} time={}ns", trace.getTraceId(), message, LocalDateTime.now().minusNanos(trace.getInitialDtt().getNano()));
                }
                threadLocalTrace.remove();
            }
        } else {
            String str = mergeLineSpace(trace);
            if ("in".equals(traceType.getName())) {
                log.info("{}{}{}", str, IN, message);
            } else if ("out".equals(traceType.getName())) {
                log.info("{}{}{} time={}ns", str, OUT, message, LocalDateTime.now().minusNanos(trace.getInitialDtt().getNano()));
            }
        }
    }

    private String mergeLineSpace(Trace trace) {
        return "|   ".repeat(Math.max(0, trace.getDepth()));
    }

}
