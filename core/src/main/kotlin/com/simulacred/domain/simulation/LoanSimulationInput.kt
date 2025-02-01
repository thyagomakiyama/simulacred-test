package com.simulacred.domain.simulation

import com.simulacred.domain.borrower.Borrower

class LoanSimulationInput private constructor(
    val borrower: Borrower,
    val loanAmount: Amount,
    val paymentTermMonths: Int,
) {
    class Builder {
        private var borrower: Borrower? = null
        private var loanAmount: Amount? = null
        private var paymentTermMonths: Int? = null

        fun borrower(borrower: Borrower) = apply { this.borrower = borrower }

        fun loanAmount(amount: Amount) = apply { this.loanAmount = amount }

        fun paymentTermMonths(months: Int) = apply { this.paymentTermMonths = months }

        fun build(): LoanSimulationInput {
            requireNotNull(paymentTermMonths) { "Payment term months must be provided" }
                .also { require(it >= 12) { "Payment term months must be greater or equals than 12" } }

            requireNotNull(loanAmount) { "Loan amount must be provided" }

            requireNotNull(borrower) { "Borrower must be provided" }

            return LoanSimulationInput(
                borrower!!,
                loanAmount!!,
                paymentTermMonths!!,
            )
        }
    }
}
