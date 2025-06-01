package com.hannes.starwars.data.model.crossref.FilmCrossRef

import androidx.room.Entity

@Entity(
    tableName = "character_species_cross_ref",
    primaryKeys = ["characterId", "speciesId"]
)
data class CharacterSpeciesCrossRef(
    val characterUrl: String,
    val speciesUrl: String
)