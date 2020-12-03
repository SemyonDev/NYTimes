package com.semyong.connector

import com.semyong.repository.GetMostPopularNewsRepository
import com.semyong.repositoryimpl.GetMostPopularNewsRepositoryImpl
import com.semyong.usecases.GetMostPopularNewsUseCase
import com.semyong.usecasesimpl.GetMostPopularNewsUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single<GetMostPopularNewsUseCase> { GetMostPopularNewsUseCaseImpl(get()) }
}