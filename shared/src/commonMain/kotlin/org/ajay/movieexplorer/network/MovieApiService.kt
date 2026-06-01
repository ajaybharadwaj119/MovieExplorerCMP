package org.ajay.movieexplorer.network

import org.ajay.movieexplorer.model.ShowDto
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.ajay.movieexplorer.model.SearchResponseDto

class MovieApiService {
    suspend fun getShows(): List<ShowDto> {

        return try {

            println("API CALL STARTED")
            val url = "https://api.tvmaze.com/shows"
            println("API SUCCESS $url")
            val response = HttpClientFactory.client
                .get(url)
                .body<List<ShowDto>>()

            println("Total shows: ${response.size}")

            response

        } catch (e: Exception) {

            println("API ERROR: ${e.message}")
            e.printStackTrace()

            emptyList()
        }
    }
    suspend fun searchShows(query: String): List<ShowDto> {
        println("SEARCH API: $query")
        val url = "https://api.tvmaze.com/search/shows?q=$query"
        println("API SUCCESS $url")
        val response = HttpClientFactory.client
            .get(url)
            .body<List<SearchResponseDto>>()
        return response.map {
            it.show
        }
    }
}