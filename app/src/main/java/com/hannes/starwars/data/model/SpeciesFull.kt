package com.hannes.starwars.data.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.hannes.starwars.data.local.model.CharacterEntity
import com.hannes.starwars.data.local.model.FilmEntity
import com.hannes.starwars.data.local.model.PlanetEntity
import com.hannes.starwars.data.local.model.SpeciesEntity
import com.hannes.starwars.data.model.crossref.FilmCrossRef.CharacterSpeciesCrossRef
import com.hannes.starwars.data.model.crossref.FilmCrossRef.FilmSpeciesCrossRef

data class SpeciesFull(
    @Embedded val species: SpeciesEntity,
    @Relation(
        parentColumn = "url",
        entityColumn = "url",
        associateBy = Junction(CharacterSpeciesCrossRef::class)
    )
    val members: List<CharacterEntity>,
    @Relation(
        parentColumn = "url",
        entityColumn = "url",
        associateBy = Junction(FilmSpeciesCrossRef::class)
    )
    val films: List<FilmEntity>,
    @Relation(
        parentColumn = "homeworldUrl",
        entityColumn = "url"
    )
    val homeworld: PlanetEntity?
)