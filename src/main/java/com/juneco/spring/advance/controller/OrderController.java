package com.juneco.spring.advance.controller;

import com.juneco.spring.advance.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/v1/order")
    public Mono<String> order(String itemId) {
        return orderService.orderItem(itemId).flatMap(sec -> Mono.just("ok"));
    }
}
