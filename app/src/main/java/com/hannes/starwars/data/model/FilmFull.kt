package com.hannes.starwars.data.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.hannes.starwars.data.local.model.CharacterEntity
import com.hannes.starwars.data.local.model.FilmEntity
import com.hannes.starwars.data.local.model.PlanetEntity
import com.hannes.starwars.data.local.model.SpeciesEntity
import com.hannes.starwars.data.model.crossref.FilmCrossRef.CharacterFilmCrossRef
import com.hannes.starwars.data.model.crossref.FilmCrossRef.FilmCharacterCrossRef
import com.hannes.starwars.data.model.crossref.FilmCrossRef.FilmPlanetCrossRef
import com.hannes.starwars.data.model.crossref.FilmCrossRef.FilmSpeciesCrossRef

data class FilmFull(
    @Embedded val film: FilmEntity,
    @Relation(
        parentColumn = "url",
        entityColumn = "url",
        associateBy = Junction(CharacterFilmCrossRef::class)
    )
    val characters: List<CharacterEntity>,
    @Relation(
        parentColumn = "url",
        entityColumn = "url",
        associateBy = Junction(FilmPlanetCrossRef::class)
    )
    val planets: List<PlanetEntity>,
    @Relation(
        parentColumn = "url",
        entityColumn = "url",
        associateBy = Junction(FilmSpeciesCrossRef::class)
    )
    val species: List<SpeciesEntity>
)