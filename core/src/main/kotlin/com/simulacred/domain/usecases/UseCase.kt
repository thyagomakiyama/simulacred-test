package com.simulacred.domain.usecases

interface UseCase<I, O> {
    suspend fun handle(input: I): O?
}
