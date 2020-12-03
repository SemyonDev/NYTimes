package com.semyong.connector

import com.semyong.connector.helpers.HeaderInterceptor
import com.semyong.data.api.ApiServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val apiModule = module {
    single(named("HeaderInterceptor")){
        HeaderInterceptor()
    }

    single(named("HttpLoggingInterceptor")){
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        val BASE_URL = "https://api.nytimes.com"
        Retrofit.Builder().baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get(named("HeaderInterceptor")))
            .addInterceptor(get(named("HttpLoggingInterceptor")))
            .build()
    }

    single<ApiServices> {
        get<Retrofit>().create(ApiServices::class.java)
    }
}