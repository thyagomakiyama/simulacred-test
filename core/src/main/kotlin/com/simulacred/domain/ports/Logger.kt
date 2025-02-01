package com.simulacred.domain.ports

interface Logger {
    fun info(message: String)

    fun warn(message: String)

    fun error(
        message: String,
        throwable: Throwable?,
    )
}
