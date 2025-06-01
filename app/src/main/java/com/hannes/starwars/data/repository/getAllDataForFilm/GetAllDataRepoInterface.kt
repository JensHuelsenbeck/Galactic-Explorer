package com.hannes.starwars.data.repository.getAllDataForFilm

import com.hannes.starwars.data.local.model.CharacterEntity
import com.hannes.starwars.data.local.model.PlanetEntity
import com.hannes.starwars.data.local.model.SpeciesEntity
import kotlinx.coroutines.flow.Flow

interface GetAllDataRepoInterface {
    suspend fun getAllPlanets(ids: List<String>): Flow<List<PlanetEntity>>
    suspend fun getAllSpecies(ids: List<String>): Flow<List<SpeciesEntity>>
    suspend fun getAllCharacters(ids: List<String>): Flow<List<CharacterEntity>>

}