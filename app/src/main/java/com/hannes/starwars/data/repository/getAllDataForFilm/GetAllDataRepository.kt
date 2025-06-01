package com.hannes.starwars.data.repository.getAllDataForFilm

import com.hannes.starwars.data.local.Dao.CharacterDao
import com.hannes.starwars.data.local.Dao.PlanetDao
import com.hannes.starwars.data.local.Dao.SpeciesDao
import com.hannes.starwars.data.local.model.CharacterEntity
import com.hannes.starwars.data.local.model.PlanetEntity
import com.hannes.starwars.data.local.model.SpeciesEntity
import kotlinx.coroutines.flow.Flow

class GetAllDataRepository (
    private val charDao: CharacterDao,
    private val speciesDao: SpeciesDao,
    private val planetDao: PlanetDao
): GetAllDataRepoInterface {

    override suspend fun getAllPlanets(ids: List<String>): Flow<List<PlanetEntity>> {
       return planetDao.getPlanetsForFilm(ids)
    }

    override suspend fun getAllSpecies(ids: List<String>): Flow<List<SpeciesEntity>> {
        return speciesDao.getSpeciesForFilm(ids)
    }

    override suspend fun getAllCharacters(ids: List<String>): Flow<List<CharacterEntity>> {
        return charDao.getCharactersForFilm(ids)
    }

}