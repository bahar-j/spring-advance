package com.juneco.spring.advance.service;

import com.juneco.spring.advance.model.Tracer;
import com.juneco.spring.advance.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ItemRepository itemRepository;
    private final Tracer tracer;

    public Mono<Long> orderItem(String itemId) {
        return itemRepository.save(itemId);
    }
}
