package com.simulacred.domain.simulation

class Simulation private constructor(
    val id: String,
    val totalToBePaid: Amount,
    val monthlyInstallment: Amount,
    val totalInterestPaid: Amount,
) {
    class Builder {
        private var id: String? = null
        private var totalToBePaid: Amount? = null
        private var monthlyInstallment: Amount? = null
        private var totalInterestPaid: Amount? = null

        fun id(id: String) =
            apply {
                this.id = id
            }

        fun totalToBePaid(amount: Amount) =
            apply {
                this.totalToBePaid = amount
            }

        fun monthlyInstallment(amount: Amount) =
            apply {
                this.monthlyInstallment = amount
            }

        fun totalInterestPaid(amount: Amount) =
            apply {
                this.totalInterestPaid = amount
            }

        fun build(): Simulation {
            requireNotNull(id) { "Id must be provided" }
            requireNotNull(totalToBePaid) { "Total to be paid must be provided" }
            requireNotNull(monthlyInstallment) { "Monthly installment must be provided" }
            requireNotNull(totalInterestPaid) { "Total interest paid must be provided" }

            return Simulation(id!!, totalToBePaid!!, monthlyInstallment!!, totalInterestPaid!!)
        }
    }
}
