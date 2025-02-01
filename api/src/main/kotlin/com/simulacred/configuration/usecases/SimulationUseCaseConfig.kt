package com.simulacred.configuration.usecases

import com.simulacred.domain.ports.Logger
import com.simulacred.domain.usecases.SimulationUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SimulationUseCaseConfig(
    private val logger: Logger,
) {
    @Bean
    fun simulationUseCase(): SimulationUseCase = SimulationUseCase(logger)
}
