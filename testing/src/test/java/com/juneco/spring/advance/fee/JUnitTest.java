package com.juneco.spring.advance.fee;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class JUnitTest {

    @Test
    public void caculate_금액이_주어지면_원단위_반올림_결과가_변환된다 () throws Exception {
        //given
        FeeCalculateType feeCalculator = FeeCalculateType.WON_UNIT_CUT;

        //when & then
        final long case1 = feeCalculator.calcaulate(500);
        assertThat(case1, is(500L));

        final long case2 = feeCalculator.calcaulate(495);
        assertThat(case2, is(490L));

        final long case3 = feeCalculator.calcaulate(-500);
        assertThat(case3, is(-500L));

        final long case4 = feeCalculator.calcaulate(-495);
        assertThat(case4, is(-490L));
    }

    @Test
    public void caculate_음수가입력되면_throwNumberFormatException () throws Exception {
        //given
        FeeCalculateType feeCalculator = FeeCalculateType.WON_UNIT_CUT;

        //when & then
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            feeCalculator.calcaulate(-1);
        });

        String expectedMessage = "음수는 허용하지 않습니다";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}