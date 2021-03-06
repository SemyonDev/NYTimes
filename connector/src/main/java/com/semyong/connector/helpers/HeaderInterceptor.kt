package com.semyong.connector.helpers

import okhttp3.Interceptor
import okhttp3.Response


class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()

        val originalHttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("api-key", "kRboaOVAj1RRuMuA5V3WDbvGCogxHVl3")
            .build()

        // Request customization: add request headers
        val requestBuilder = original.newBuilder()
            .url(url)
            .method(original.method(), original.body())

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}