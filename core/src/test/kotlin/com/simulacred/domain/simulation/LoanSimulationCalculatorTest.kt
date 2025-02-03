package com.simulacred.domain.simulation

import com.simulacred.domain.borrower.Borrower
import io.kotest.core.spec.style.StringSpec

import io.kotest.matchers.shouldBe
import java.time.LocalDate

class LoanSimulationCalculatorTest : StringSpec({
    fun loanAmount(value: Long) = Amount.Builder().value(value).currency("BRL").build()
    val borrower = Borrower.Builder()
        .email("test@test.com")
        .birthDate(LocalDate.now().minusYears(29))
        .build()

    "should calculate and build simulation correctly for a given input" {
        val loanAmount = loanAmount(100000)
        val paymentTermMonths = 12

        val input = LoanSimulationInput.Builder()
            .borrower(borrower)
            .loanAmount(loanAmount)
            .paymentTermMonths(paymentTermMonths)
            .build()

        val simulation = LoanSimulationCalculator.calculateAndBuildSimulation(input)

        val expectedMonthlyInstallment = 8469
        val expectedTotalToBePaid = expectedMonthlyInstallment * paymentTermMonths
        val expectedTotalInterestPaid = expectedTotalToBePaid - loanAmount.value

        simulation.monthlyInstallment.value shouldBe expectedMonthlyInstallment
        simulation.monthlyInstallment.currency shouldBe "BRL"
        simulation.totalToBePaid.value shouldBe expectedTotalToBePaid
        simulation.totalToBePaid.currency shouldBe "BRL"
        simulation.totalInterestPaid.value shouldBe expectedTotalInterestPaid
        simulation.totalInterestPaid.currency shouldBe "BRL"
        simulation.id.isNotBlank() shouldBe true
    }
})
