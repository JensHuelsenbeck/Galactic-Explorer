package com.hannes.starwars.data.model.crossref.FilmCrossRef

import androidx.room.Entity

@Entity(
    tableName = "film_species_cross_ref",
    primaryKeys = ["filmUrl", "speciesUrl"]
)
data class FilmSpeciesCrossRef(
    val filmUrl: String,
    val speciesUrl: String
)