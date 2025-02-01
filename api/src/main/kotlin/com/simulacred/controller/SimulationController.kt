package com.simulacred.controller

import com.simulacred.domain.ports.Logger
import com.simulacred.domain.simulation.SimulationRequestDTO
import com.simulacred.domain.usecases.SimulationUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/")
class SimulationController(
    private val logger: Logger,
    private val simulationUseCase: SimulationUseCase,
) {
    @GetMapping
    suspend fun simulate(): ResponseEntity<Any> {
        logger.info("Request received")
        simulationUseCase.handle(SimulationRequestDTO(25))
        return ResponseEntity.ok(mapOf("foo" to "bar"))
    }
}
