package com.simulacred.controller

import com.simulacred.controller.dto.ErrorDTO
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.web.bind.annotation.RestController

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@RestController
@ApiResponse(
    responseCode = "400",
    description = "Invalid request parameters",
    content = [Content(schema = Schema(implementation = ErrorDTO::class))],
)
@ApiResponse(
    responseCode = "401",
    description = "Unauthorized",
    content = [Content(schema = Schema(implementation = ErrorDTO::class))],
)
annotation class ApiController
