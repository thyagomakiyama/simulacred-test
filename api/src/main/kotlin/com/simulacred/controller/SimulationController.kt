package com.simulacred.controller

import com.simulacred.controller.dto.LoanSimulationRequestDTO
import com.simulacred.controller.dto.LoanSimulationResponseDTO
import com.simulacred.domain.ports.Logger
import com.simulacred.domain.usecases.SimulationUseCase
import com.simulacred.utils.maskEmail
import com.simulacred.utils.toLoanSimulationResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Tag(name = "Loan Simulation", description = "Endpoints for loan simulation")
@ApiController
@RequestMapping("/loans")
class SimulationController(
    private val logger: Logger,
    private val simulationUseCase: SimulationUseCase,
) {
    @PostMapping("/simulate")
    @Operation(summary = "Simulate a loan", description = "Simulates a loan based on provided details")
    @ApiResponse(
        responseCode = "200",
        description = "Success",
        content = [Content(schema = Schema(implementation = LoanSimulationResponseDTO::class))],
    )
    suspend fun simulate(
        @RequestBody loanSimulationDTO: LoanSimulationRequestDTO,
    ): ResponseEntity<LoanSimulationResponseDTO> {
        logger.info("Receive loan simulation request to ${loanSimulationDTO.email.maskEmail()}")
        val simulation = simulationUseCase.handle(loanSimulationDTO.toModel()).toLoanSimulationResponse()
        return ResponseEntity.ok(simulation)
    }
}
