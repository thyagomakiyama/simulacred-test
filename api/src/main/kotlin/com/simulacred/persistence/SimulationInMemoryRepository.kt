package com.simulacred.persistence

import com.simulacred.domain.ports.SimulationRepository
import com.simulacred.domain.simulation.Simulation
import org.springframework.stereotype.Component

@Component
class SimulationInMemoryRepository : SimulationRepository {
    private val simulations = mutableListOf<Simulation>()

    override suspend fun store(simulation: Simulation) {
        simulations.add(simulation)
    }

    override suspend fun getById(id: String): Simulation? {
        return simulations.find { it.id == id }
    }

    override suspend fun getByBorrowerEmail(email: String): List<Simulation> {
        return simulations.filter { it.borrowerEmail == email }
    }

    override suspend fun getAll(): List<Simulation> {
        return simulations
    }
}
