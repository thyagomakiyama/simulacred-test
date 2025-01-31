package com.simulacred.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/")
class HelloController {
    @GetMapping
    suspend fun hello(): String = "hello"
}
