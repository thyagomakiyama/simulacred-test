package com.simulacred.domain.borrower

import java.time.LocalDate

class Borrower private constructor(
    val email: String,
    val birthDate: LocalDate,
) {
    fun age(): Int = birthDate.calculateAge()

    class Builder {
        private var email: String? = null
        private var birthDate: LocalDate? = null

        fun email(email: String) = apply { this.email = email }

        fun birthDate(date: LocalDate) = apply { this.birthDate = date }

        fun build(): Borrower {
            val email = requireNotNull(email) { "Borrower email must be provided" }
            val birthDate = requireNotNull(birthDate) { "Borrower birth date must be provided" }

            require(birthDate.calculateAge() >= 18) { "Borrower must be at least 18 years old" }
            require(email.isValidEmail()) { "Borrower email is invalid" }

            return Borrower(email, birthDate)
        }
    }
}
