package com.simulacred.controller.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "DTO representing an error")
data class ErrorDTO(
    @Schema(description = "Constant about error", example = "ERROR_CODE", required = true)
    val code: String,
    @Schema(description = "Error description", example = "Something went wrong", required = true)
    val message: String,
)
