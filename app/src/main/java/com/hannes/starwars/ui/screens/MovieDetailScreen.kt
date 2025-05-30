package com.hannes.starwars.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hannes.starwars.R
import com.hannes.starwars.data.local.model.FilmEntity
import com.hannes.starwars.ui.components.CategoryTitle
import com.hannes.starwars.ui.components.CharacterList
import com.hannes.starwars.ui.components.PlanetList
import com.hannes.starwars.ui.components.SpeciesList
import com.hannes.starwars.ui.theme.basic
import com.hannes.starwars.ui.theme.starWarsOrange
import com.hannes.starwars.ui.theme.starwarsfont
import com.hannes.starwars.ui.viewmodel.HomescreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MovieDetailScreen(
    modifier: Modifier = Modifier,
    movie: FilmEntity,
    viewModel: HomescreenViewModel = koinViewModel()
) {
    val planets = viewModel.planetEntities.collectAsState()
    val characters = viewModel.characterEntities.collectAsState()
    val species = viewModel.speciesEntities.collectAsState()

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null
        )
        Spacer(modifier.padding(vertical = 8.dp))
        Text(
            text = "episode ${viewModel.episodeNumb(movie)}",
            fontFamily = basic,
            style = MaterialTheme.typography.headlineSmall,
            color = starWarsOrange,
        )
        Text(
            text = "episode ${viewModel.episodeNumb(movie)}",
            fontFamily = starwarsfont,
            color = starWarsOrange,
            fontSize = 17.sp
        )
        Spacer(modifier.padding(vertical = 8.dp))

        Card() {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "movie details",
                    fontFamily = basic,
                    color = starWarsOrange,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .padding(top = 8.dp)
                )

                Text(
                    text = "movie details",
                    fontFamily = starwarsfont,
                    color = starWarsOrange.copy(alpha = 0.5f),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .padding(top = 8.dp)
                )
            }

            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)

            ) {
                Column {

                    Row {
                        Text(
                            text = "title: ",
                            color = starWarsOrange,
                            fontFamily = starwarsfont,

                            )
                        Text(
                            text = movie.title,
                            fontWeight = FontWeight.Bold

                        )
                    }

                    Row {
                        Text(
                            text = "release date: ",
                            color = starWarsOrange,
                            fontFamily = starwarsfont,


                            )
                        Text(
                            text = movie.release_date,
                            fontWeight = FontWeight.Bold

                        )
                    }

                    Row {
                        Text(
                            text = "director: ",
                            color = starWarsOrange,
                            fontFamily = starwarsfont,


                            )
                        Text(
                            text = movie.director,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Row {
                        Text(
                            text = "producer: ",
                            color = starWarsOrange,
                            fontFamily = starwarsfont,


                            )
                        Text(
                            text = movie.producer,
                            fontWeight = FontWeight.Bold

                        )
                    }

                }

                Spacer(Modifier.weight(1f))


            }
        }
        LazyColumn(modifier
            .weight(1f)
            .padding(8.dp)
            .fillMaxWidth()
        ) {
            item {
                Spacer(modifier.padding(vertical = 8.dp))
                PlanetList(planetList = planets.value )

                CategoryTitle(
                    text = "residents"
                )

                CharacterList(characterList = characters.value)
                CategoryTitle(
                    text = "Species"
                )
                SpeciesList(speciesList = species.value)
            }
        }
    }
}
