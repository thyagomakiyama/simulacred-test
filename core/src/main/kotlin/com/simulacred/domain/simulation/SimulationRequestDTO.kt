package com.simulacred.domain.simulation

data class SimulationRequestDTO(
    val age: Int,
) {
    override fun toString(): String = "AGE: ${this.age}"
}
