package com.simulacred.common

import org.slf4j.Logger
import org.slf4j.LoggerFactory

fun logger(): Logger = LoggerFactory.getLogger(Thread.currentThread().stackTrace[2].className)
