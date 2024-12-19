package com.plcoding.bookpedia.book.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// @SerialName is a name from API
@Serializable
data class SearchedBookDto(
    @SerialName("key") val id: String,
    @SerialName("title") val title: String,
    @SerialName("language") val languages: List<String>? = null,
    @SerialName("cover_i") val coverAlternativeKey: Int? = null,
    @SerialName("auth_key") val authorKeys: List<String>? = null,
    @SerialName("auth_name") val authorNames: List<String>? = null,
    @SerialName("cover_edition_key") val coverKey: Int? = null,
    @SerialName("first_publish_year") val firstPublishYear: Int? = null,
    @SerialName("ratings_average") val ratingsAverage: Double? = null,
    @SerialName("number_of_pages_median") val numPagesMedian: Int? = null,
    @SerialName("ratings_count") val ratingsCount: Int? = null,
    @SerialName("edition_count") val numEditions: Int? = null,
    )