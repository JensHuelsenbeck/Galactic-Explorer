package com.hannes.starwars.data.model.crossref.FilmCrossRef

import androidx.room.Entity

@Entity(
    tableName = "film_species_cross_ref",
    primaryKeys = ["filmId", "speciesId"]
)
data class FilmSpeciesCrossRef(
    val filmId: String,
    val speciesId: String
)