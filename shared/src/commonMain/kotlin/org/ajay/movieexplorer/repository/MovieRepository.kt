package org.ajay.movieexplorer.repository

import org.ajay.movieexplorer.MovieDatabase
import org.ajay.movieexplorer.database.DatabaseDriverFactory
import org.ajay.movieexplorer.model.Movie
import org.ajay.movieexplorer.network.MovieApiService

class MovieRepository( databaseDriverFactory: DatabaseDriverFactory) {

    private val apiService = MovieApiService()
    private val database =
        MovieDatabase(
            databaseDriverFactory.createDriver()
        )


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

    suspend fun searchMovies(query: String): List<Movie> {
        return apiService.searchShows(query).map { show ->

            Movie(
                id = show.id,
                title = show.name,
                rating = show.rating?.average ?: 0.0
            )
        }
    }
}