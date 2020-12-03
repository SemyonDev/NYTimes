package com.semyong.common

import kotlinx.coroutines.flow.MutableStateFlow

class EventManager {

    val throwableFlow = MutableStateFlow<Throwable?>(null)

    fun flow(throwable: Throwable) {
        throwableFlow.value = throwable
    }

}