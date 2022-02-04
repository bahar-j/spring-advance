package com.juneco.spring.advance.repository;

import com.juneco.spring.advance.model.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Log4j2
@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final Tracer tracer;

    public Mono<Long> save(String itemId) {
        if (itemId.equals("ex")) {
            throw new IllegalArgumentException("예외 발생 !");
        }
        return sleep(3);
    }

    private Mono<Long> sleep(int seconds) {
        return Mono.delay(Duration.ofSeconds(seconds));
    }
}
