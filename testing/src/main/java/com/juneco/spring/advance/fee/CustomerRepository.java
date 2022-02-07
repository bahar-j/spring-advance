package com.juneco.spring.advance.fee;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
public class CustomerRepository {

    public Customer findOne(long customerId) {
        log.info("finding customer info with custermerId: {}", customerId);
        return new Customer("find", "find@gmail.com", true);
    }

    public void savePoint(Customer customer, long point) {
        log.info("saving customer point... customer: {}, point: {}", customer, point);
    }
}
