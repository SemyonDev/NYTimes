package com.semyong.entities

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Media(
    @Json(name = "type")
    val type: String? = null,
    @Json(name = "subtype")
    val subtype: String? = null,
    @Json(name = "caption")
    val caption: String? = null,
    @Json(name = "copyright")
    val copyright: String? = null,
    @field:Json(name = "media-metadata")
    val mediaMetadata: @RawValue List<MediaMetadata>? = null
) : Parcelable