package com.hannes.starwars.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hannes.starwars.data.model.Film
import com.hannes.starwars.ui.theme.basic
import com.hannes.starwars.ui.theme.starwarsfont

@Composable
fun MovieList(
    movieList: List<Film>,
    modifier: Modifier = Modifier
) {
    Column {
        CategoryTitle("Movies",  modifier.padding(horizontal = 8.dp))
        LazyRow {

            items(movieList) {
                MovieItem(it)
            }
        }
    }
}