package com.hannes.starwars.data.repository.speciesRepo

import com.hannes.starwars.data.local.model.SpeciesEntity
import com.hannes.starwars.data.model.Film
import com.hannes.starwars.data.model.Species
import com.hannes.starwars.data.remote.ApiService


class SpeciesRepository(
    private val apiService: ApiService
) : SpeciesRepositoryInterface {
    override suspend fun getSpecies(): List<Species> {
        val response = apiService.getAllSpecies()
        if (response.isSuccessful) {
            return response.body()?.results ?: emptyList()
        } else {
            throw Exception("API Error: ${response.code()}")
        }
    }

    override suspend fun createSpeciesEntity(species: Species): SpeciesEntity {
       val speciesEntity = SpeciesEntity(
           speciesName = species.name,
           classification = species.classification,
           designation = species.designation,
           average_height = species.average_height,
           skin_colors = species.skin_colors,
           hair_colors = species.hair_colors,
           eye_colors = species.eye_colors,
           average_lifespan = species.average_lifespan,
           homeworld = species.homeworld,
           language = species.language,
           url = species.url,
           speciesImage = ""
       )
        return speciesEntity

    }

}