package com.hannes.starwars.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import com.hannes.starwars.data.datasource.dummyMovie
import com.hannes.starwars.ui.components.Header
import com.hannes.starwars.ui.components.MovieItem
import com.hannes.starwars.ui.theme.basic
import com.hannes.starwars.ui.theme.starwarsfont

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        Spacer(Modifier.height(8.dp))
        Column(Modifier.padding(8.dp)) {
            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    text = "Movies",
                    fontFamily = basic,
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.Yellow,
                )
                Text(
                    text = " Movies",
                    fontFamily = starwarsfont,
                    color = Color.Yellow,
                    style = MaterialTheme.typography.bodyLarge,
                )
                Spacer(Modifier.weight(1f))
            }
            LazyRow {

              items(dummyMovie) {
                  MovieItem(it)
              }

            }
        }

    }
}