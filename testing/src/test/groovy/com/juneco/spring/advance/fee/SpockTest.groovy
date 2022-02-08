package com.juneco.spring.advance.fee


import spock.lang.Specification
import spock.lang.Unroll

import java.math.RoundingMode

class SpockTest extends Specification {

    def "495를 원단위로 반올림하면 500이 된다"() {
        given: "495가 주어지고"
        BigDecimal 금액 = BigDecimal.valueOf(495)

        when: "원단위 반올림하면"
        BigDecimal 원단위_반올림 = 금액.setScale(-1, RoundingMode.HALF_UP)

        then: "500이 된다"
        원단위_반올림 == 500
    }

    def "computing the maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b | c
        5 | 1 | 5
        3 | 9 | 9
    }

    @Unroll // 메소드 이름에 지정된 템플릿에 따라 테스트 결과를 보여줌
    def "금액이 주어지면 원단위 반올림 결과가 반환된다 [금액: #amount, 결과: #result]"() {
        given:
        def feeCalculator = FeeCalculateType.WON_UNIT_CUT

        expect:
        feeCalculator.calcaulate(amount) == result

        where:
        amount | result
        500L | 500L
        495L | 490L
        -500L | -500L
        -495L | -495L
    }

    def "음수가 입력되면 NumberFormatException이 발생한다"() {
        given:
        def feeCalculator = FeeCalculateType.WON_UNIT_CUT

        when:
        feeCalculator.calcaulate(-1)

        then:
        def e = thrown(NumberFormatException.class)
        e.message == "음수는 허용하지 않습니다"
    }

}
