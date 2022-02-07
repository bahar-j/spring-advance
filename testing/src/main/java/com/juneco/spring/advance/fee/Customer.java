package com.juneco.spring.advance.fee;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Customer {
    private String name;
    private String email;
    private Boolean isVip;

    public Customer(String name, String email, Boolean isVip) {
        this.name = name;
        this.email = email;
        this.isVip = isVip;
    }
}
