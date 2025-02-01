package com.simulacred.domain.simulation

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class AmountTest : StringSpec({
    "should create Amount with valid currency and value" {
        Amount.Builder().currency("BRL").value(2000).build().also {
            it.currency shouldBe "BRL"
            it.value shouldBe 2000
        }
    }

    "should throw exception for negative value" {
        shouldThrow<IllegalArgumentException> {
            Amount.Builder().currency("USD").value(-100).build()
        }.also { it.message shouldBe "Value must be non-negative" }
    }

    "should throw exception for invalid currency" {
        shouldThrow<IllegalArgumentException> {
            Amount.Builder().currency("EUR").value(1000).build()
        }.also { it.message shouldBe "Currency must be either BRL or USD" }
    }
})
