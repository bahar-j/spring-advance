package com.juneco.spring.advance.fee;

import org.springframework.stereotype.Service;

@Service
public class AmountService {
    public int getAmount() {
        return 1;
    }
    public int getAmount(int testNum) { return testNum+1; }
}
