package com.hannes.starwars.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hannes.starwars.data.model.Film
import com.hannes.starwars.ui.theme.starWarsOrange
import com.hannes.starwars.ui.theme.starwarsfont
import com.hannes.starwars.ui.viewmodel.HomescreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MovieList(
    modifier: Modifier = Modifier,
    movieList: List<Film>,
    viewModel: HomescreenViewModel = koinViewModel()
) {

    CategoryTitle("Movies", modifier.padding(horizontal = 8.dp))
    LazyColumn(modifier.height(200.dp)) {
        items(movieList) { movie ->
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF1C1C1E)
                )
            ) {
                Column (
                    modifier
                        .padding(vertical = 6.dp, horizontal = 8.dp),
                ) {
                    Text(
                        text = "Episode ${viewModel.episodeNumb(movie)} ",
                        fontSize = 20.sp,
                        color = starWarsOrange,
                        fontFamily = starwarsfont
                    )
                    Text(
                        text = movie.title,
                        fontSize = 18.sp,
                        color = Color.White,

                    )
                }
            }
        }
    }
}
