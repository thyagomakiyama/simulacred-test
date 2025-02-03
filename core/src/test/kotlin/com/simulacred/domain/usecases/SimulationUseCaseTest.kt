package com.simulacred.domain.usecases

import com.simulacred.domain.borrower.Borrower
import com.simulacred.domain.ports.Logger
import com.simulacred.domain.ports.SimulationRepository
import com.simulacred.domain.simulation.Amount
import com.simulacred.domain.simulation.LoanSimulationInput
import io.kotest.core.spec.style.StringSpec
import io.mockk.coVerify
import io.mockk.mockk
import java.time.LocalDate

class SimulationUseCaseTest : StringSpec({
    val logger = mockk<Logger>(relaxed = true)
    val repository = mockk<SimulationRepository>(relaxed = true)
    val simulationUseCase = SimulationUseCase(logger, repository)

    "should persists simulation" {
        val input = LoanSimulationInput.Builder()
            .borrower(Borrower.Builder().email("test@test.com").birthDate(LocalDate.now().minusYears(18)).build())
            .loanAmount(Amount.Builder().currency("BRL").value(100000).build())
            .paymentTermMonths(12)
            .build()

        simulationUseCase.handle(input)

        coVerify(exactly = 1) { repository.store(any()) }
    }
})
