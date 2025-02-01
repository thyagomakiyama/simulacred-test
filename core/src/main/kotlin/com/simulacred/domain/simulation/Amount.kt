package com.simulacred.domain.simulation

class Amount private constructor(
    val value: Long,
    val currency: String,
) {
    class Builder {
        private var value: Long = 0
        private var currency: String = "BRL"

        fun value(value: Long) =
            apply {
                require(value >= 0) { "Value must be non-negative" }
                this.value = value
            }

        fun currency(currency: String) =
            apply {
                require(currency in setOf("BRL", "USD")) { "Currency must be either BRL or USD" }
                this.currency = currency
            }

        fun build() = Amount(value, currency)
    }
}
