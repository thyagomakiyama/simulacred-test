package com.simulacred.controller.validators

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import java.time.LocalDate
import java.time.Period

@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [AgeValidator::class])
annotation class Age(
    val min: Int,
    val message: String = "Invalid age",
)

class AgeValidator : ConstraintValidator<Age, LocalDate> {
    private var minAge: Int = 0

    override fun initialize(age: Age) {
        this.minAge = age.min
    }

    override fun isValid(
        value: LocalDate?,
        context: ConstraintValidatorContext?,
    ): Boolean {
        if (value == null) return false
        return Period.between(value, LocalDate.now()).years >= minAge
    }
}
