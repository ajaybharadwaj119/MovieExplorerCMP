package org.ajay.movieexplorer.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.ajay.movieexplorer.MovieCard
import org.ajay.movieexplorer.model.Movie

@Composable
fun HomeScreen() {

    var searchText by remember {
        mutableStateOf("")
    }

    val movieList = listOf(
        Movie(1, "Interstellar", 8.6),
        Movie(2, "Inception", 8.8),
        Movie(3, "The Dark Knight", 9.0),
        Movie(4, "Avengers Endgame", 8.4),
        Movie(5, "Oppenheimer", 8.5)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {

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