package com.hannes.starwars.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hannes.starwars.R
import com.hannes.starwars.data.fakes.dummyCharacters
import com.hannes.starwars.data.fakes.dummyEntityMovie
import com.hannes.starwars.data.fakes.dummyMovie
import com.hannes.starwars.data.fakes.dummyPlanets
import com.hannes.starwars.data.local.model.SpeciesEntity
import com.hannes.starwars.ui.components.CategoryTitle
import com.hannes.starwars.ui.components.ListItem
import com.hannes.starwars.ui.components.MovieRow
import com.hannes.starwars.ui.components.PlanetList
import com.hannes.starwars.ui.theme.basic
import com.hannes.starwars.ui.theme.starWarsOrange
import com.hannes.starwars.ui.theme.starwarsfont
import com.hannes.starwars.ui.viewmodel.HomescreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SpeciesScreen(
    species: SpeciesEntity,
    modifier: Modifier = Modifier,
    viewModel: HomescreenViewModel = koinViewModel()
) {

    val films = viewModel.filmEntities.collectAsState()
    val planets = viewModel.planetEntities.collectAsState()
    val characters = viewModel.characterEntities.collectAsState()

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null
        )
        Spacer(modifier.padding(vertical = 8.dp))
        Text(
            text = species.speciesName,
            fontFamily = basic,
            style = MaterialTheme.typography.headlineSmall,
            color = starWarsOrange,
        )
        Text(
            text = species.speciesName,
            fontFamily = starwarsfont,
            color = starWarsOrange,
            fontSize = 17.sp
        )
        Spacer(modifier.padding(vertical = 8.dp))

        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF1C1C1E)
            )
        ) {

            Text(
                text = "species details",
                fontFamily = starwarsfont,
                color = starWarsOrange,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(top = 8.dp)
            )


            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)

            ) {
                Column {

                    Row {
                        Text(
                            text = "classification: ",
                            color = starWarsOrange,

                            )
                        Text(
                            text = species.classification,

                            )
                    }

                    Row {
                        Text(
                            text = "designation: ",
                            color = starWarsOrange,


                            )
                        Text(
                            text = species.designation ?: "-",

                            )
                    }

                    Row {
                        Text(
                            text = "average height: ",
                            color = starWarsOrange,


                            )
                        Text(
                            text = species.average_height ?: "-",
                        )
                    }

                    Row {
                        Text(
                            text = "skin colors: ",
                            color = starWarsOrange,


                            )
                        Text(
                            text = species.skin_colors ?: "-",
                        )
                    }

                }

                Spacer(Modifier.weight(1f))

                Column {

                    Row {
                        Text(
                            text = "language: ",
                            color = starWarsOrange,

                            )
                        Text(
                            text = species.language ?: "-",
                            )
                    }

                    Row {
                        Text(
                            text = "eye colors: ",
                            color = starWarsOrange,

                            )
                        Text(
                            text = species.eye_colors ?: "-",

                            )
                    }

                    Row {
                        Text(
                            text = "average lifespan: ",
                            color = starWarsOrange,

                            )
                        Text(
                            text = species.average_lifespan ?: "-",


                            )
                    }

                    Row {
                        Text(
                            text = "homeworld: ",
                            color = starWarsOrange,

                            )
                        Text(
                            text = species.homeworld ?: "-",

                            )
                    }

                }
                Spacer(Modifier.weight(1f))

            }
        }
        LazyColumn(modifier.padding(8.dp)) {
            item {
                Spacer(modifier.padding(vertical = 8.dp))
                MovieRow(
                    movieList = films.value,
                    onMovieClick = { }
                )
                CategoryTitle(
                    text = "characters"
                )

                CategoryTitle(text = "characters")

                LazyColumn(modifier = Modifier.height(160.dp)) {
                    items(characters.value) { char ->
                        ListItem(title = char.characterName, subTitle = char.birth_year)
                    }
                }
                CategoryTitle(
                    text = "planets"
                )
                PlanetList(
                    planetList = planets.value,
                    onPlanetClick = { }
                )            }
        }
    }
}