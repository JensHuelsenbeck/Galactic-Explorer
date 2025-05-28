package com.hannes.starwars.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hannes.starwars.data.fakes.dummyCharacters

@Composable
fun CharacterList(modifier: Modifier = Modifier) {
    CategoryTitle(text = "Characters")

    LazyColumn(modifier = Modifier.height(160.dp)) {
        items(dummyCharacters) { char ->
            ListItem(title = char.name, subTitle = char.birth_year)
        }
    }
}