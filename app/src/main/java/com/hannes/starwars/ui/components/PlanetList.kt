package com.hannes.starwars.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hannes.starwars.data.model.Planet

@Composable
fun PlanetList(
    modifier: Modifier = Modifier,
    planetList: List<Planet>
) {

    CategoryTitle("Planets", modifier.padding(horizontal = 8.dp))
    LazyColumn(modifier.height(160.dp)) {
        items(planetList) { planet ->
            ListItem(title = planet.name, subTitle = null)
        }

    }
}