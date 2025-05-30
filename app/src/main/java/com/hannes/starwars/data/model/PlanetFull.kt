package com.hannes.starwars.data.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.hannes.starwars.data.local.model.CharacterEntity
import com.hannes.starwars.data.local.model.FilmEntity
import com.hannes.starwars.data.local.model.PlanetEntity
import com.hannes.starwars.data.model.crossref.FilmCrossRef.FilmPlanetCrossRef


data class PlanetFull(
    @Embedded val planet: PlanetEntity,
    @Relation(
        parentColumn = "url",
        entityColumn = "url",
        associateBy = Junction(FilmPlanetCrossRef::class)
    )
    val films: List<FilmEntity>,
    @Relation(
        parentColumn = "url",
        entityColumn = "homeworldUrl"
    )
    val residents: List<CharacterEntity>
)