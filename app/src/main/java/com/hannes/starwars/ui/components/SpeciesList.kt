package com.hannes.starwars.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hannes.starwars.data.datasource.dummySpecies

@Composable
fun SpeciesList(modifier: Modifier = Modifier) {
    LazyColumn(modifier = Modifier.height(160.dp)) {
        items(dummySpecies) { species ->
            ListItem(title = species.name, subTitle = species.classification)
        }
    }
}