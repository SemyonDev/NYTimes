package com.semyong.presentation.fragments.listfragment

import com.semyong.entities.Result


interface ListAction {
    fun onItemClick(resultItem: Result)
}