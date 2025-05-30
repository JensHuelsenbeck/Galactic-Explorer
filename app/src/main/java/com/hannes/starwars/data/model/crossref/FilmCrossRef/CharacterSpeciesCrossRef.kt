package com.hannes.starwars.data.model.crossref.FilmCrossRef

import androidx.room.Entity

@Entity(
    tableName = "character_species_cross_ref",
    primaryKeys = ["characterUrl", "speciesUrl"]
)
data class CharacterSpeciesCrossRef(
    val characterUrl: String,
    val speciesUrl: String
)