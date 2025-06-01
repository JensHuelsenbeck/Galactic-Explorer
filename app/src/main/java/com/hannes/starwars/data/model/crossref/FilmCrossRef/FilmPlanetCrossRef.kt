package com.hannes.starwars.data.model.crossref.FilmCrossRef

import androidx.room.Entity

@Entity(
    tableName = "film_planet_cross_ref",
    primaryKeys = ["filmId", "planetId"]
)
data class FilmPlanetCrossRef(
    val filmId: String,
    val planetId: String
)