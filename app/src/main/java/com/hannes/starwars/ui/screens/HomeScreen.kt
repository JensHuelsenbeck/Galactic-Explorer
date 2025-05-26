package com.hannes.starwars.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hannes.starwars.data.datasource.dummyCharacters
import com.hannes.starwars.data.datasource.dummyMovie
import com.hannes.starwars.data.datasource.dummyPlanets
import com.hannes.starwars.ui.components.CategoryTitle
import com.hannes.starwars.ui.components.Header
import com.hannes.starwars.ui.components.ListItem
import com.hannes.starwars.ui.components.MovieList
import com.hannes.starwars.ui.components.PlanetList

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
        MovieList(dummyMovie)
        Spacer(Modifier.height(8.dp))

        CategoryTitle(text = "Characters")
        LazyColumn {
            items(dummyCharacters) { char ->
                ListItem(title = char.name, subTitle = char.birth_year)
            }
        }
        Spacer(Modifier.height(8.dp))
        PlanetList(planetList = dummyPlanets)
    }
}
