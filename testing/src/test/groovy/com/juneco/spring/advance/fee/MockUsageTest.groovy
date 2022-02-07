package com.juneco.spring.advance.fee

import spock.lang.Specification

class MockUsageTest extends Specification {

    def "API를 통해 받은 값을 원단위 버림 계산한다."() {
        given:
        def mockAmountService = Mock(AmountService.class)

        when:
        long amount = mockAmountService.getAmount()

        then:
        mockAmountService.getAmount() >> 999
        999 == amount
        990L == FeeCalculateType.WON_UNIT_CUT.calcaulate(amount)
    }

    def "Vip는 이벤트에 참여하면 포인트 적립이 2번 발생한다."() {
        given:
        def mockCustomerRepository = Mock(CustomerRepository)
        CustomerService customerService = new CustomerService(mockCustomerRepository)
        long customerId = 1
        long point = 1000
        def customer = new Customer("jojoldu", "jojoldu@gmail.com", true)

        when:
        customerService.joinEvent(customerId, point)

        then:
        mockCustomerRepository.findOne(customerId) >> customer
        2 * mockCustomerRepository.savePoint(customer, point)
    }
}
