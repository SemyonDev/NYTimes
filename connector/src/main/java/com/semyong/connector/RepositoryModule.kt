package com.semyong.connector

import com.semyong.repository.GetMostPopularNewsRepository
import com.semyong.repositoryimpl.GetMostPopularNewsRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<GetMostPopularNewsRepository> { GetMostPopularNewsRepositoryImpl(get()) }
}