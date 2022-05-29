package com.miharu.planetphoto.core.base

interface BaseUseCaseWithParams<P, R> {
    suspend fun invoke(params: P): R
}

interface BaseUseCaseNoParams<R> {
    suspend fun run(): R
}