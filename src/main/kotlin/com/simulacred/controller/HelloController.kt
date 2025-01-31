package com.simulacred.controller

import com.simulacred.common.logger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/")
class HelloController {
    private val logger = logger()

    @GetMapping
    suspend fun hello(): String {
        logger.info("HELLO!")
        return "HELLO"
    }
}
