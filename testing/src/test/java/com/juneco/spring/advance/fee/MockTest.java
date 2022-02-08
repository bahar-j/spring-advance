package com.juneco.spring.advance.fee;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockTest {

    @Mock
    private AmountService amountService;

    @Test
    void API에서_받은값_원단위버림() {
        // given
        AmountService amountService = mock(AmountService.class);
        when(amountService.getAmount()).thenReturn(999);

        // when
        long amount = amountService.getAmount();

        // then
        assertEquals(998, amount);
        assertEquals(990L, FeeCalculateType.WON_UNIT_CUT.calcaulate(amount));
    }


    // 메소드 호출 횟수 세는 법 있긴 한거 같은데 이건 아님
//    @Test
//    void VIP이벤트_참여시_포인트적립_2번() {
//        // given
//        CustomerRepository mockCustomerRepository = mock(CustomerRepository.class);
//        long customerId = 1;
//        Customer customer = new Customer("june", "june@gmail.com", true);
//        when(mockCustomerRepository.findOne(customerId)).thenReturn(customer);
//
//        long point = 1000;
//        CustomerService customerService = new CustomerService(mockCustomerRepository);
//
//        // when
//        customerService.joinEvent(customerId, point);
//
//        // then
//        Collection<Invocation> invocations = mockingDetails(mockCustomerRepository).getInvocations();
//        assertEquals(2, invocations.size());
//    }


}
