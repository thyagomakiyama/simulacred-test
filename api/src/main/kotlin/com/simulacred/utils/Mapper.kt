package com.simulacred.utils

import com.simulacred.controller.dto.AmountDTO
import com.simulacred.controller.dto.LoanSimulationResponseDTO
import com.simulacred.domain.simulation.Amount
import com.simulacred.domain.simulation.Simulation

fun Simulation.toLoanSimulationResponse(): LoanSimulationResponseDTO =
    LoanSimulationResponseDTO(
        id = id,
        totalToBePaid = totalToBePaid.toAmountDTO(),
        monthlyInstallment = monthlyInstallment.toAmountDTO(),
        totalInterestPaid = totalInterestPaid.toAmountDTO(),
    )

fun Amount.toAmountDTO(): AmountDTO =
    AmountDTO(
        currency = currency,
        value = value,
    )
