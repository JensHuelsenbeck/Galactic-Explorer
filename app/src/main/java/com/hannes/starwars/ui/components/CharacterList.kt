package com.hannes.starwars.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hannes.starwars.data.fakes.dummyCharacters
import com.hannes.starwars.data.local.model.CharacterEntity

@Composable
fun CharacterList(
    modifier: Modifier = Modifier,
    characterList: List<CharacterEntity>
    ) {
    CategoryTitle(text = "Characters")

    LazyColumn(modifier = Modifier.height(160.dp)) {
        items(characterList) { char ->
            ListItem(title = char.characterName, subTitle = char.birth_year)
        }
    }
}