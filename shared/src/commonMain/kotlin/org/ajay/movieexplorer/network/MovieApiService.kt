package org.ajay.movieexplorer.network

import org.ajay.movieexplorer.model.ShowDto
import io.ktor.client.call.body
import io.ktor.client.request.get

class MovieApiService {
    suspend fun getShows(): List<ShowDto> {
        return HttpClientFactory.client
            .get("https://api.tvmaze.com/shows")
            .body()
    }
}