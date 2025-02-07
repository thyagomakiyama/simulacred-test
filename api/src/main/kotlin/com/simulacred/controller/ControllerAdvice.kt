package com.simulacred.controller

import com.simulacred.controller.dto.ErrorDTO
import com.simulacred.utils.Slf4jLogger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ControllerAdvice(
    private val logger: Slf4jLogger,
) {
    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(e: IllegalArgumentException): ResponseEntity<ErrorDTO> {
        logger.error("Illegal Argument Error: ${e.message}", e)
        val error = ErrorDTO("ILLEGAL_ARGUMENT", e.message ?: "Illegal argument was provided")
        return ResponseEntity.badRequest().body(error)
    }
}
