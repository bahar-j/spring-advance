package com.juneco.spring.advance.service;

import com.juneco.spring.advance.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ItemRepository itemRepository;

    public Mono<Long> orderItem(String itemId) {
        return itemRepository.save(itemId);
    }
}
