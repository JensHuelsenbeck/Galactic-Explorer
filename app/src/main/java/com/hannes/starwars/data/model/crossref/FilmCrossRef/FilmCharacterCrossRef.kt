package com.hannes.starwars.data.model.crossref.FilmCrossRef

import androidx.room.Entity

@Entity(
    tableName = "filmcharacterlist",
    primaryKeys = ["filmId", "characterId"]
)
data class FilmCharacterCrossRef(
    val filmId: String,
    val characterId: String
)
