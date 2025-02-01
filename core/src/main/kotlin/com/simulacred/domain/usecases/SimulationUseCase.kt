package com.simulacred.domain.usecases

import com.simulacred.domain.ports.Logger
import com.simulacred.domain.simulation.SimulationRequestDTO
import com.simulacred.domain.simulation.SimulationResponseDTO

class SimulationUseCase(
    private val logger: Logger,
) : UseCase<SimulationRequestDTO, SimulationResponseDTO> {
    override suspend fun handle(input: SimulationRequestDTO): SimulationResponseDTO? {
        logger.info(input.toString())
        return null
    }
}
