package com.simulacred.configuration.usecases

import com.simulacred.domain.ports.Logger
import com.simulacred.domain.usecases.SimulationUseCase
import com.simulacred.persistence.SimulationInMemoryRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SimulationUseCaseConfig(
    private val logger: Logger,
    private val simulationInMemoryRepository: SimulationInMemoryRepository,
) {
    @Bean
    fun simulationUseCase(): SimulationUseCase = SimulationUseCase(logger, simulationInMemoryRepository)
}
