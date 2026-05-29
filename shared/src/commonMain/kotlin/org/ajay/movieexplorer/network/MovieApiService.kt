package org.ajay.movieexplorer.network

import org.ajay.movieexplorer.model.ShowDto
import io.ktor.client.call.body
import io.ktor.client.request.get

class MovieApiService {
    suspend fun getShows(): List<ShowDto> {
        println("API CALL STARTED")
        val response = HttpClientFactory.client
            .get("https://api.tvmaze.com/shows")
            .body<List<ShowDto>>()
        println("API SUCCESS")
        println("Total shows: ${response.size} \n $response")

        return response
    }
}