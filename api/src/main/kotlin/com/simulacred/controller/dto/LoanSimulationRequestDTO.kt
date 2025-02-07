package com.simulacred.controller.dto

import com.simulacred.controller.validators.Age
import com.simulacred.domain.borrower.Borrower
import com.simulacred.domain.simulation.LoanSimulationInput
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import java.time.LocalDate

@Schema(description = "Loan simulation request")
data class LoanSimulationRequestDTO(
    @field:NotNull(message = "Loan amount cannot be null")
    @field:Valid
    @Schema(description = "Loan amount details", required = true)
    val loanAmount: AmountDTO,
    @field:NotBlank(message = "Email cannot be blank")
    @field:Email(message = "Invalid email format")
    @Schema(description = "User email", example = "user@example.com", required = true)
    val email: String,
    @field:NotNull(message = "Birth date cannot be null")
    @field:Past(message = "Birth date must be in the past")
    @field:Age(min = 18, message = "User must be at least 18 years old")
    @Schema(description = "User birth date", example = "1990-01-01", required = true)
    val birthDate: LocalDate,
    @field:Min(value = 1, message = "Payment term must be at least 1 month")
    @field:Max(value = 360, message = "Payment term cannot exceed 360 months")
    @Schema(description = "Loan payment term in months", example = "24", required = true)
    val paymentTermMonths: Int,
) {
    fun toModel(): LoanSimulationInput =
        LoanSimulationInput.Builder()
            .loanAmount(loanAmount.toModel())
            .borrower(
                Borrower.Builder()
                    .email(email)
                    .birthDate(birthDate)
                    .build(),
            )
            .paymentTermMonths(paymentTermMonths)
            .build()
}
