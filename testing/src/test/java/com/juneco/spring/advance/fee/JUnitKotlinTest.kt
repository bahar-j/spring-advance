package com.juneco.spring.advance.fee

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class JUnitKotlinTest {

    @ParameterizedTest
    @ArgumentsSource(SumArguments::class)
    fun `caculate_금액이_주어지면_원단위_반올림_결과가_변환된다` (
            amount: Long, expected: Long
    ) {
        // given
        val feeCalculator = FeeCalculateType.WON_UNIT_CUT

        // when
        val actual = feeCalculator.calcaulate(amount)

        // then
        Assertions.assertEquals(expected, actual)
    }

    class SumArguments : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
            return Stream.of(
                    Arguments.of(500, 500L),
                    Arguments.of(495, 490L),
                    Arguments.of(-500, -500L),
                    Arguments.of(-495, -490L)
            )
        }
    }

}