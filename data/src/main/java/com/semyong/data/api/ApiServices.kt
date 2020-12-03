package com.semyong.data.api

import com.semyong.entities.News
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {

    @GET("/svc/mostpopular/v2/viewed/{days}")
    suspend fun getNews(@Path("days") days:String): News
// 1.json
}