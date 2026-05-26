package org.ajay.movieexplorer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {

    MaterialTheme {

        var searchText by remember {
            mutableStateOf("")
        }
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

            item {
                MovieCard(
                    movieName = "Interstellar",
                    rating = "8.6"
                )
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
            }

            item {
                MovieCard(
                    movieName = "Inception",
                    rating = "8.8"
                )
            }

            item {
                Spacer(modifier = Modifier.height(12.dp))
            }

            item {
                MovieCard(
                    movieName = "Batman",
                    rating = "9.8"
                )
            }
        }
    }
}