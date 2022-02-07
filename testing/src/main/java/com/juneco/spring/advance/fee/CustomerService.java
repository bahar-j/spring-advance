package com.juneco.spring.advance.fee;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void joinEvent(long customerId, long point) {
        Customer customer = customerRepository.findOne(customerId);

        customerRepository.savePoint(customer, point);

        if(customer.getIsVip()) {
            customerRepository.savePoint(customer, point);
        }
    }
}
