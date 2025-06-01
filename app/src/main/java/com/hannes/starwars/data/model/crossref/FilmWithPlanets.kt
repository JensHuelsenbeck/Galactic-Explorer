package com.hannes.starwars.data.model.crossref

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.hannes.starwars.data.local.model.FilmEntity
import com.hannes.starwars.data.local.model.PlanetEntity
import com.hannes.starwars.data.model.crossref.FilmCrossRef.FilmPlanetCrossRef


data class FilmWithPlanets(
    @Embedded
    val film: FilmEntity,
    @Relation(
        parentColumn = "filmId",
        entityColumn = "planetId",
        associateBy = Junction(FilmPlanetCrossRef::class)
    )
    val planets: List<PlanetEntity>
)
