package com.simulacred.configuration

import com.simulacred.domain.ports.Logger
import com.simulacred.utils.Slf4jLogger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LoggerConfig {
    @Bean
    fun logger(): Logger = Slf4jLogger()
}
