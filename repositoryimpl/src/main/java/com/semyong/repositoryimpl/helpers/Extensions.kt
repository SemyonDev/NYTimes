package com.semyong.repositoryimpl.helpers

import com.semyong.entities.MyResponse


suspend fun <R> makeApiCall(
    call: suspend () -> R,
    errorMessage: String = "Something went wrong"
): MyResponse<R> = try {
    MyResponse.Success(call())
} catch (e: Exception) {
    MyResponse.Error(Exception(errorMessage, e))
}