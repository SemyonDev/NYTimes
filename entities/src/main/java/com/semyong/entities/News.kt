package com.semyong.entities

import com.squareup.moshi.Json

data class News(
    @Json(name = "status")
    val status: String? = null,
    @Json(name = "copyright")
    val copyright: String? = null,
    @Json(name = "num_results")
    val numResults: Int? = null,
    @Json(name = "results")
    val results: List<Result>? = null
)