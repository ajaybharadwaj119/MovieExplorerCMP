package org.ajay.movieexplorer.repository

import org.ajay.movieexplorer.model.Movie
import org.ajay.movieexplorer.network.MovieApiService

class MovieRepository {

    private val apiService = MovieApiService()

    suspend fun getMovies(): List<Movie> {
        println("Repository: Fetching Movies")

        val result = apiService.getShows().map { show ->

            Movie(
                id = show.id,
                title = show.name,
                rating = show.rating?.average ?: 0.0
            )
        }

        println("Repository Success")
        println("Movie count: ${result.size} \n $result")

        return result
    }
}