package com.simulacred.controller.dto

import com.simulacred.domain.simulation.Amount
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Positive

@Schema(description = "DTO representing an amount with currency")
data class AmountDTO(
    @field:NotNull(message = "Amount value cannot be null")
    @field:Positive(message = "Amount value must be positive")
    @Schema(description = "Minor monetary amount", example = "10000", required = true)
    val value: Long,
    @field:NotNull(message = "Amount currency cannot be null")
    @field:Pattern(regexp = "^(BRL|USD)$", message = "Currency must be BRL or USD")
    @Schema(description = "Currency type", example = "BRL", required = true)
    val currency: String,
) {
    fun toModel(): Amount =
        Amount.Builder()
            .currency(currency)
            .value(value)
            .build()
}
