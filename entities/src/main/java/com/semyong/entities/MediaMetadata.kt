package com.semyong.entities

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MediaMetadata (
    @Json(name = "url")
    val url: String? = null,
    @Json(name = "format")
    val format: String? = null,
    @Json(name = "height")
    val height: String? = null,
    @Json(name = "width")
    val width: String? = null
):Parcelable