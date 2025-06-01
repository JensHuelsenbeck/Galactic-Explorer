package com.hannes.starwars.data.model.crossref

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.hannes.starwars.data.local.model.FilmEntity
import com.hannes.starwars.data.local.model.SpeciesEntity
import com.hannes.starwars.data.model.crossref.FilmCrossRef.FilmSpeciesCrossRef

data class FilmWithSpecies(
    @Embedded val film: FilmEntity,
    @Relation(
        parentColumn = "filmId",
        entityColumn = "speciesId",
        associateBy = Junction(FilmSpeciesCrossRef::class)
    )
    val songs: List<SpeciesEntity>
)
