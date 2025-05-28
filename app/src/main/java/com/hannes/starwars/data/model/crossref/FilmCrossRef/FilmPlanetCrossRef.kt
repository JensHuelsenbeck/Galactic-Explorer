package com.hannes.starwars.data.model.crossref.FilmCrossRef

import androidx.room.Entity

@Entity(tableName = "filmplanetslist", primaryKeys = ["filmId", "planetId"])
 data class FilmPlanetCrossRef(
     val filmId: String,
     val planetId: String
 )
