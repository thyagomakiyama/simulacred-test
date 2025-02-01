package com.simulacred.domain.borrower

import java.time.LocalDate
import java.time.Period
import java.util.regex.Pattern

fun LocalDate.calculateAge(): Int = Period.between(this, LocalDate.now()).years

fun String.isValidEmail(): Boolean {
    val emailRegex =
        "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"
    val pattern = Pattern.compile(emailRegex)
    return pattern.matcher(this).matches()
}
