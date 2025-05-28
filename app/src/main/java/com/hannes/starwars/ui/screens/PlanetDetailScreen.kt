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
import com.hannes.starwars.data.fakes.dummySpecies
import com.hannes.starwars.ui.components.CategoryTitle
import com.hannes.starwars.ui.components.ListItem
import com.hannes.starwars.ui.components.MovieRow
import com.hannes.starwars.ui.theme.basic
import com.hannes.starwars.ui.theme.starWarsOrange
import com.hannes.starwars.ui.theme.starwarsfont

@Composable
fun PlanetDetailScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.tatooine),
            contentDescription = null
        )
        Spacer(modifier.padding(vertical = 8.dp))
        Text(
            text = "tatooine",
            fontFamily = basic,
            style = MaterialTheme.typography.headlineSmall,
            color = starWarsOrange,
        )
        Text(
            text = "tatooine",
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
                text = "planet details",
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
                            text = "rotation period: ",
                            color = starWarsOrange,

                            )
                        Text(
                            text = "23",

                            )
                    }

                    Row {
                        Text(
                            text = "orbital period: ",
                            color = starWarsOrange,


                            )
                        Text(
                            text = "304",

                            )
                    }

                    Row {
                        Text(
                            text = "diameter: ",
                            color = starWarsOrange,


                            )
                        Text(
                            text = "10465",
                        )
                    }

                    Row {
                        Text(
                            text = "climate: ",
                            color = starWarsOrange,


                            )
                        Text(
                            text = "arid",
                        )
                    }

                }

                Spacer(Modifier.weight(1f))

                Column {

                    Row {
                        Text(
                            text = "gravity: ",
                            color = starWarsOrange,

                            )
                        Text(
                            text = "1 standard",

                            )
                    }

                    Row {
                        Text(
                            text = "terrain: ",
                            color = starWarsOrange,

                            )
                        Text(
                            text = "dessert",

                            )
                    }

                    Row {
                        Text(
                            text = "surface water: ",
                            color = starWarsOrange,

                            )
                        Text(
                            text = "1%",


                            )
                    }

                    Row {
                        Text(
                            text = "population: ",
                            color = starWarsOrange,

                            )
                        Text(
                            text = "200000",

                            )
                    }

                }
                Spacer(Modifier.weight(1f))

            }
        }
        LazyColumn(modifier.padding(8.dp)) {
            item {
                Spacer(modifier.padding(vertical = 8.dp))
                MovieRow(movieList = dummyEntityMovie)
                CategoryTitle(
                    text = "residents"
                )

                LazyColumn(modifier = Modifier.height(160.dp)) {
                    items(dummyCharacters) { char ->
                        ListItem(title = char.name, subTitle = char.birth_year)
                    }
                }
                CategoryTitle(
                    text = "Species"
                )
                LazyColumn(modifier = Modifier.height(160.dp)) {
                    items(dummySpecies) { species ->
                        ListItem(title = species.name, subTitle = species.classification)
                    }
                }
            }
        }
    }
}
