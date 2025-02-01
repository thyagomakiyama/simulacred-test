package com.simulacred.utils

import com.simulacred.domain.ports.Logger
import org.slf4j.LoggerFactory

class Slf4jLogger : Logger {
    private val logger = LoggerFactory.getLogger("[SIMULACRED_API]")

    override fun info(message: String) {
        logger.info(message)
    }

    override fun warn(message: String) {
        logger.warn(message)
    }

    override fun error(
        message: String,
        throwable: Throwable?,
    ) {
        logger.error(message, throwable)
    }
}
