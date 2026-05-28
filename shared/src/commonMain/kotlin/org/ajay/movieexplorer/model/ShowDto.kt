package org.ajay.movieexplorer.model

import kotlinx.serialization.Serializable

@Serializable
data class ShowDto(
    val id: Int,
    val name: String,
    val rating: RatingDto?
)

@Serializable
data class RatingDto(
    val average: Double?
)