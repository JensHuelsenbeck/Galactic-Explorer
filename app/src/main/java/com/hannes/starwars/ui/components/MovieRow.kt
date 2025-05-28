package com.hannes.starwars.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hannes.starwars.data.model.Film
import com.hannes.starwars.data.model.FilmEntity

@Composable
fun MovieRow(
    movieList: List<FilmEntity>,
    modifier: Modifier = Modifier
) {
    Column {
        CategoryTitle("Movies",  modifier.padding(horizontal = 8.dp))
        LazyRow {

            items(movieList) {
                MovieCard(it)
            }
        }
    }
}