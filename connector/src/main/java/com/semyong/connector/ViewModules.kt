package com.semyong.connector

import com.semyong.presentation.fragments.listfragment.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val listViewModel = module {
    viewModel { ListViewModel(get(), get()) }

}

