package com.hannes.starwars.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.hannes.starwars.R
import com.hannes.starwars.ui.components.CategoryTitle
import com.hannes.starwars.ui.theme.basic
import com.hannes.starwars.ui.theme.starWarsOrange
import com.hannes.starwars.ui.theme.starwarsfont

@Composable
fun DetailScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
    ) {
        Image(
            painter = painterResource(R.drawable.tatooine),
            contentDescription = null
        )
        Text(
            text = "Tatooine",
            fontFamily = basic,
            style = MaterialTheme.typography.headlineSmall,
            color = starWarsOrange,
        )
        Text(
            text = "Tatooine",
            fontFamily = starwarsfont,
            color = starWarsOrange,
            fontSize = 17.sp
        )
        Card() {
            Row() {
                Column {
                    Text(
                        text = "Planet Details",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Row {
                        Text(
                            text = "rotation period"
                        )
                        Text(
                            text = "23"
                        )
                    }

                    Row {
                        Text(
                            text = "orbital period"
                        )
                        Text(
                            text = "304"
                        )
                    }

                    Row {
                        Text(
                            text = "Diameter"
                        )
                        Text(
                            text = "10465"
                        )
                    }

                    Row {
                        Text(
                            text = "climate"
                        )
                        Text(
                            text = "arid"
                        )
                    }

                }

                Column {

                    Row {
                        Text(
                            text = "gravity"
                        )
                        Text(
                            text = "1 standard"
                        )
                    }

                    Row {
                        Text(
                            text = "terrain"
                        )
                        Text(
                            text = "dessert"
                        )
                    }

                    Row {
                        Text(
                            text = "surface water"
                        )
                        Text(
                            text = "1%"
                        )
                    }

                    Row {
                        Text(
                            text = "Population"
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

        Column {
            Row {
                Text(
                    text = "luke skywalker"
                )
            }
        }
    }

}
