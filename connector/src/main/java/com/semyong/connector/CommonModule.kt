package com.semyong.connector

import com.semyong.common.EventManager
import org.koin.dsl.module

val commonModule = module {
    single { EventManager() }
}