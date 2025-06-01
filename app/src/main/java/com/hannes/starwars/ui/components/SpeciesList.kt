package com.hannes.starwars.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hannes.starwars.data.local.model.SpeciesEntity

@Composable
fun SpeciesList(
    modifier: Modifier = Modifier,
    speciesList: List<SpeciesEntity>,
    onSpeciesClick: (SpeciesEntity) -> Unit

) {
    CategoryTitle("Species", modifier.padding(horizontal = 8.dp))

    LazyRow(modifier = Modifier.height(160.dp)) {
        items(speciesList) { species ->
            ListItem(title = species.speciesName,
                subTitle = species.classification,
                onClick = { onSpeciesClick(species) }
            )
        }
    }
}