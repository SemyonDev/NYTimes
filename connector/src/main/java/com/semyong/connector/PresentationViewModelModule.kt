package com.semyong.connector

import com.semyong.presentation.NewsViewModel
import com.semyong.repository.GetMostPopularNewsRepository
import com.semyong.repositoryimpl.GetMostPopularNewsRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { NewsViewModel(get(), get()) }
}