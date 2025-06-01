package com.hannes.starwars.data.model

import com.hannes.starwars.data.local.model.CharacterEntity
import com.hannes.starwars.data.local.model.PlanetEntity
import com.hannes.starwars.data.local.model.SpeciesEntity

data class FilmFull(
    val characters: List<CharacterEntity>,
    val planets: List<PlanetEntity>,
    val species: List<SpeciesEntity>
)