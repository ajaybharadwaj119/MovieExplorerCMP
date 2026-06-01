package org.ajay.movieexplorer.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.ajay.movieexplorer.MovieCard
import org.ajay.movieexplorer.model.Movie
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import kotlinx.coroutines.launch
import org.ajay.movieexplorer.repository.MovieRepository

@Composable
fun HomeScreen() {

    var searchText by remember {
        mutableStateOf("")
    }

    var isLoading by remember {
        mutableStateOf(true)
    }

    var errorMessage by remember {
        mutableStateOf<String?>(null)
    }

    var movieList by remember {
        mutableStateOf<List<Movie>>(emptyList())
    }

    val repository = remember {
        MovieRepository()
    }

    LaunchedEffect(Unit) {
        println("HomeScreen launched")
        isLoading = true
        errorMessage = null

        try {
            movieList = repository.getMovies()
            println("Movies loaded in UI")
        } catch (e: Exception) {
            println("API ERROR: ${e.message}")
            errorMessage = e.message
        } finally {
            isLoading = false
        }
    }

    when {

        isLoading -> {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                CircularProgressIndicator()
            }
        }

        errorMessage != null -> {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "Error: $errorMessage"
                )
            }
        }

        else -> {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(16.dp)
            ) {

                item {
                    Spacer(modifier = Modifier.height(8.dp))
                }

                item {
                    Text(
                        text = "🎬 Movie Explorer",
                        style = MaterialTheme.typography.headlineLarge
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(8.dp))
                }

                item {
                    Text(
                        text = "Discover Popular Movies",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(20.dp))
                }

                item {
                    OutlinedTextField(
                        value = searchText,
                        onValueChange = {
                            searchText = it
                            if (searchText.isNotBlank()) {
                                kotlinx.coroutines.MainScope().launch {
                                    movieList = repository.searchMovies(searchText)
                                }
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text("Search Movies")
                        },
                        shape = RoundedCornerShape(16.dp)
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(24.dp))
                }

                item {
                    Text(
                        text = "Trending Movies",
                        style = MaterialTheme.typography.titleLarge
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }

                items(movieList) { movie ->

                    MovieCard(movie)

                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }

}