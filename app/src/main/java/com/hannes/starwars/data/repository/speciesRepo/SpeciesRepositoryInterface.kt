package com.hannes.starwars.data.repository.speciesRepo

import com.hannes.starwars.data.model.Film
import com.hannes.starwars.data.model.Species

interface SpeciesRepositoryInterface {
    suspend fun getSpecies(): List<Species>
}