package com.simulacred.domain.simulation

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.shouldBeExactly

class InterestRateCalculatorTest : StringSpec({
    val testCases =
        listOf(
            25 to 0.05,
            26 to 0.03,
            41 to 0.02,
            61 to 0.04,
        )

    testCases.forEach { (age, expectedYearRate) ->
        "should return correct monthly rate for age $age" {
            val rate = InterestRateCalculator.monthlyRate(age)
            rate shouldBeExactly (expectedYearRate / 12)
        }
    }
})
