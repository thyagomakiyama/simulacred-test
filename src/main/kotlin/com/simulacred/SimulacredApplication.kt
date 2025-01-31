package com.simulacred

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimulacredApplication

fun main(args: Array<String>) {
    runApplication<SimulacredApplication>(*args)
}
