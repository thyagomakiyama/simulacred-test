package com.simulacred.domain.borrower

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDate

class BorrowerTest : StringSpec({
    val email = "test@test.com"
    val birthDate = LocalDate.now().minusYears(18)

    "should throw exception if email not provided" {
        shouldThrow<IllegalArgumentException> {
            Borrower.Builder()
                .birthDate(birthDate)
                .build()
        }.also { it.message shouldBe "Borrower email must be provided" }
    }

    "should throw exception if email provided is invalid" {
        shouldThrow<IllegalArgumentException> {
            Borrower.Builder()
                .email("test")
                .birthDate(birthDate)
                .build()
        }.also { it.message shouldBe "Borrower email is invalid" }
    }

    "should throw exception if birth date not provided" {
        shouldThrow<IllegalArgumentException> {
            Borrower.Builder()
                .email(email)
                .build()
        }.also { it.message shouldBe "Borrower birth date must be provided" }
    }

    "should throw exception if borrower age is lass than 18 years" {
        shouldThrow<IllegalArgumentException> {
            Borrower.Builder()
                .email(email)
                .birthDate(LocalDate.now().minusYears(2))
                .build()
        }.also { it.message shouldBe "Borrower must be at least 18 years old" }
    }

    "should build a borrower" {
        Borrower.Builder()
            .email(email)
            .birthDate(birthDate)
            .build()
            .also {
                it.email shouldBe email
                it.age() shouldBe 18
                it.birthDate shouldBe birthDate
            }
    }
})
