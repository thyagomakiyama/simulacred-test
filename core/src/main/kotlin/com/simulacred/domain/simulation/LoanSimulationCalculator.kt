package com.simulacred.domain.simulation

import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode
import java.util.UUID
import kotlin.math.pow

object LoanSimulationCalculator {
    private fun Amount.calculateMonthlyInstallment(
        monthlyInterestRate: Double,
        paymentTermMonths: Int,
    ): Amount {
        val discountFactor = (1 + monthlyInterestRate).pow(-paymentTermMonths.toDouble())
        val monthlyValue = (value * monthlyInterestRate) / (1 - discountFactor)
        val roundedMonthlyValue = monthlyValue.toBigDecimal().setScale(4, RoundingMode.HALF_UP).toLong()

        return Amount.Builder()
            .value(roundedMonthlyValue)
            .currency(currency)
            .build()
    }

    private fun Amount.calculateTotalToBePaid(paymentTermMonths: Int): Amount = Amount.Builder()
        .value(value.times(paymentTermMonths))
        .currency(currency)
        .build()


    private fun Amount.calculateTotalInterestPaid(loanAmount: Amount): Amount = Amount.Builder()
        .value(value - loanAmount.value)
        .currency(currency)
        .build()

    fun calculateAndBuildSimulation(input: LoanSimulationInput): Simulation {
        val interestRate = InterestRateCalculator.monthlyRate(input.borrower.age())
        val loanAmount = input.loanAmount
        val monthlyInstallment = loanAmount.calculateMonthlyInstallment(interestRate, input.paymentTermMonths)
        val totalToBePaid = monthlyInstallment.calculateTotalToBePaid(input.paymentTermMonths)
        val totalInterestPaid = totalToBePaid.calculateTotalInterestPaid(loanAmount)

        return Simulation.Builder()
            .id(UUID.randomUUID().toString())
            .totalToBePaid(totalToBePaid)
            .monthlyInstallment(monthlyInstallment)
            .totalInterestPaid(totalInterestPaid)
            .build()
    }
}
