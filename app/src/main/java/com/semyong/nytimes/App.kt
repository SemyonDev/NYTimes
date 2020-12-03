package com.semyong.nytimes

import android.app.Application
import com.semyong.connector.apiModule
import com.semyong.connector.commonModule
import com.semyong.connector.listViewModel
import com.semyong.connector.presentationModule
import com.semyong.connector.repositoryModule
import com.semyong.connector.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    repositoryModule,
                    apiModule,
                    useCaseModule,
                    listViewModel,
                    presentationModule,
                    commonModule
                )
            )
        }
    }
}