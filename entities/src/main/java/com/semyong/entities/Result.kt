package com.semyong.entities

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Result(
    @Json(name = "uri")
    val uri: String? = null,
    @Json(name = "url")
    val url: String? = null,
    @Json(name = "section")
    val section: String? = null,
    @Json(name = "subsection")
    val subsection: String? = null,
    @field:Json(name = "adx_keywords")
    val adxKeywords: String? = null,
    @Json(name = "byline")
    val byline: String? = null,
    @Json(name = "type")
    val type: String? = null,
    @Json(name = "title")
    val title: String? = null,
    @Json(name = "abstract")
    val abstract: String? = null,
    @field:Json(name = "des_facet")
    val desFacet: List<String>? = null,
    @field:Json(name = "org_facet")
    val orgFacet: List<String>? = null,
    @field:Json(name = "per_facet")
    val perFacet: List<String>? = null,
    @field:Json(name = "geo_facet")
    val geoFacet: List<String>? = null,
    @Json(name = "media")
    val media: @RawValue List<Media>? = null
) : Parcelable