package com.miharu.planetphoto.core.extension

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun <T> Flow<T>.throttleFirst(periodMillis: Long = throttleTimeMs): Flow<T> {
    require(periodMillis > 0) { "period should be positive" }
    return flow {
        var lastTime = 0L
        collect { value ->
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastTime >= periodMillis) {
                lastTime = currentTime
                emit(value)
            }
        }
    }
}

const val throttleTimeMs = 1000L