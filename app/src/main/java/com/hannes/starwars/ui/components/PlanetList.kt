package com.hannes.starwars.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hannes.starwars.data.local.model.PlanetEntity
import com.hannes.starwars.data.model.Planet

@Composable
fun PlanetList(
    modifier: Modifier = Modifier,
    planetList: List<PlanetEntity>,
    onPlanetClick: (PlanetEntity) -> Unit
) {

    CategoryTitle("Planets", modifier.padding(horizontal = 8.dp))
    LazyRow(modifier.height(80.dp)) {
        items(planetList) { planet ->
            ListItem(title = planet.planetName,
                subTitle = planet.gravity + " G",
                onClick = { onPlanetClick(planet) }
            )
        }

    }
}