package com.simulacred.controller.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Loan simulation response")
data class LoanSimulationResponseDTO(
    @Schema(description = "Unique identifier of the loan simulation", example = "123e4567-e89b-12d3-a456-426614174000")
    val id: String,
    @Schema(description = "Total amount to be paid including interest")
    val totalToBePaid: AmountDTO,
    @Schema(description = "Monthly installment amount")
    val monthlyInstallment: AmountDTO,
    @Schema(description = "Total interest paid over the loan period")
    val totalInterestPaid: AmountDTO,
)
