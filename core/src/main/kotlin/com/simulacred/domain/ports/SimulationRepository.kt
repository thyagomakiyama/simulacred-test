package com.simulacred.domain.ports

import com.simulacred.domain.simulation.Simulation

interface SimulationRepository {
    suspend fun store(simulation: Simulation)
    suspend fun getById(id: String): Simulation?
    suspend fun getByBorrowerEmail(email: String): List<Simulation>
    suspend fun getAll(): List<Simulation>
}