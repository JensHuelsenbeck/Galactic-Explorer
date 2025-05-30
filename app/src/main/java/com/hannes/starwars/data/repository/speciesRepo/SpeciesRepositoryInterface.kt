package com.hannes.starwars.data.repository.speciesRepo

import com.hannes.starwars.data.local.model.SpeciesEntity
import com.hannes.starwars.data.model.Film
import com.hannes.starwars.data.model.Species

interface SpeciesRepositoryInterface {
    suspend fun getSpecies(): List<Species>
    suspend fun createSpeciesEntity(species: Species): SpeciesEntity

}