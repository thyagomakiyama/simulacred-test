package com.simulacred.domain.simulation

import com.simulacred.domain.borrower.Borrower
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDate

class LoanSimulationInputTest : StringSpec({
    val loanAmount = Amount.Builder().value(5000).currency("BRL").build()
    val borrower = Borrower.Builder()
        .email("test@test.com")
        .birthDate(LocalDate.now().minusYears(18))
        .build()
    val paymentTermMonths = 24

    "should throw exception if borrower not provided" {
        shouldThrow<IllegalArgumentException> {
            LoanSimulationInput.Builder()
                .loanAmount(loanAmount)
                .paymentTermMonths(paymentTermMonths)
                .build()
        }.also { it.message shouldBe "Borrower must be provided" }
    }

    "should throw exception if payment term months not provided" {
        shouldThrow<IllegalArgumentException> {
            LoanSimulationInput.Builder()
                .loanAmount(loanAmount)
                .borrower(borrower)
                .build()
        }.also { it.message shouldBe "Payment term months must be provided" }
    }

    "should throw exception if payment term is less than 12 months" {
        shouldThrow<IllegalArgumentException> {
            LoanSimulationInput.Builder()
                .loanAmount(loanAmount)
                .borrower(borrower)
                .paymentTermMonths(10)
                .build()
        }.also { it.message shouldBe "Payment term months must be greater or equals than 12" }
    }

    "should throw exception if loan amount not provided" {
        shouldThrow<IllegalArgumentException> {
            LoanSimulationInput.Builder()
                .borrower(borrower)
                .paymentTermMonths(paymentTermMonths)
                .build()
        }.also { it.message shouldBe "Loan amount must be provided" }
    }

    "should create loan simulation input successfully if valid" {
        LoanSimulationInput.Builder()
            .loanAmount(loanAmount)
            .borrower(borrower)
            .paymentTermMonths(paymentTermMonths)
            .build().also {
                it.loanAmount shouldBe loanAmount
                it.borrower shouldBe borrower
                it.paymentTermMonths shouldBe paymentTermMonths
            }
    }
})
