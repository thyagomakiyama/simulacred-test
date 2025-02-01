package com.simulacred.domain.usecases

import com.simulacred.domain.ports.Logger
import com.simulacred.domain.ports.SimulationRepository
import com.simulacred.domain.simulation.LoanSimulationCalculator
import com.simulacred.domain.simulation.LoanSimulationInput
import com.simulacred.domain.simulation.Simulation

class SimulationUseCase(
    private val logger: Logger,
    private val repository: SimulationRepository
) : UseCase<LoanSimulationInput, Simulation> {
    override suspend fun handle(input: LoanSimulationInput): Simulation {
        logger.info("Calculate loan simulation to ${input.borrower.email}")
        val loanSimulation = LoanSimulationCalculator.calculateAndBuildSimulation(input)
        repository.store(loanSimulation)
        return loanSimulation
    }
}
