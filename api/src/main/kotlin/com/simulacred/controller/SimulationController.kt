package com.simulacred.controller

import com.simulacred.domain.borrower.Borrower
import com.simulacred.domain.ports.Logger
import com.simulacred.domain.simulation.Amount
import com.simulacred.domain.simulation.LoanSimulationInput
import com.simulacred.domain.usecases.SimulationUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController("/")
class SimulationController(
    private val logger: Logger,
    private val simulationUseCase: SimulationUseCase,
) {
    @GetMapping
    suspend fun simulate(): ResponseEntity<Any> {
        logger.info("Request received")
        val amount =
            Amount.Builder()
                .currency("BRL")
                .value(1000)
                .build()
        val borrower =
            Borrower.Builder()
                .email("test@test.com")
                .birthDate(LocalDate.now().minusYears(18))
                .build()
        val simulationInput =
            LoanSimulationInput.Builder()
                .loanAmount(amount)
                .borrower(borrower)
                .paymentTermMonths(12)
                .build()

        simulationUseCase.handle(simulationInput)
        return ResponseEntity.ok(mapOf("foo" to "bar"))
    }
}
