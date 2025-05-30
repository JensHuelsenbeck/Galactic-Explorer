package com.hannes.starwars.data.model.crossref.FilmCrossRef

import androidx.room.Entity

@Entity(
    tableName = "character_film_cross_ref",
    primaryKeys = ["characterUrl", "filmUrl"]
)
data class CharacterFilmCrossRef(
    val characterUrl: String,
    val filmUrl: String
)
