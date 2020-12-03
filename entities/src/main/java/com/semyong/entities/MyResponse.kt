package com.semyong.entities

sealed class MyResponse<out R> {
    data class Success<out R>(val data: R) : MyResponse<R>()
    data class Error(val exception: Exception) : MyResponse<Nothing>()
}