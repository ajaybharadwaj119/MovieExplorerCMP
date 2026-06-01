package org.ajay.movieexplorer.model

import kotlinx.serialization.Serializable

@Serializable
data class SearchResponseDto(
    val show: ShowDto
)