package com.hannes.starwars.data.model.crossref.FilmCrossRef

import androidx.room.Entity

@Entity(
    tableName = "film_planet_cross_ref",
    primaryKeys = ["filmUrl", "planetUrl"]
)
data class FilmPlanetCrossRef(
    val filmUrl: String,
    val planetUrl: String
)