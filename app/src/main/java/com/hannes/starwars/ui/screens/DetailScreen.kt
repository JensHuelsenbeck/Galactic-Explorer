package com.hannes.starwars.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hannes.starwars.R
import com.hannes.starwars.data.datasource.dummyCharacters
import com.hannes.starwars.data.datasource.dummyMovie
import com.hannes.starwars.ui.components.CategoryTitle
import com.hannes.starwars.ui.components.ListItem
import com.hannes.starwars.ui.components.MovieList
import com.hannes.starwars.ui.theme.basic
import com.hannes.starwars.ui.theme.starWarsOrange
import com.hannes.starwars.ui.theme.starwarsfont

@Composable
fun DetailScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.tatooine),
            contentDescription = null
        )
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
        Card() {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "planet details",
                    fontFamily = basic,
                    color = starWarsOrange,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .padding(top = 8.dp)
                )

                Text(
                    text = " planet details",
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
                            text = "rotation period: "
                        )
                        Text(
                            text = "23"
                        )
                    }

                    Row {
                        Text(
                            text = "orbital period: "
                        )
                        Text(
                            text = "304"
                        )
                    }

                    Row {
                        Text(
                            text = "diameter: "
                        )
                        Text(
                            text = "10465"
                        )
                    }

                    Row {
                        Text(
                            text = "climate: "
                        )
                        Text(
                            text = "arid"
                        )
                    }

                }

                Spacer(Modifier.weight(1f))

                Column {

                    Row {
                        Text(
                            text = "gravity: "
                        )
                        Text(
                            text = "1 standard"
                        )
                    }

                    Row {
                        Text(
                            text = "terrain: "
                        )
                        Text(
                            text = "dessert"
                        )
                    }

                    Row {
                        Text(
                            text = "surface water: "
                        )
                        Text(
                            text = "1%"
                        )
                    }

                    Row {
                        Text(
                            text = "population: "
                        )
                        Text(
                            text = "200000"
                        )
                    }

                }
            }
        }

        CategoryTitle(
            text = "residents"
        )

        LazyColumn {
            items(dummyCharacters) { char ->
                ListItem(title = char.name, subTitle = char.birth_year)
            }
        }
        MovieList(dummyMovie)
    }

}
