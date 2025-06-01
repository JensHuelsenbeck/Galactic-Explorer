package com.hannes.starwars.data.model.crossref

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.hannes.starwars.data.model.Character
import com.hannes.starwars.data.model.Film
import com.hannes.starwars.data.model.crossref.FilmCrossRef.FilmCharacterCrossRef

data class FilmWithCharacters(
    @Embedded
    val film: Film,
    @Relation(
        parentColumn = "filmId",
        entityColumn = "characterId",
        associateBy = Junction(FilmCharacterCrossRef::class)
    )
    val planets: List<Character>
)
