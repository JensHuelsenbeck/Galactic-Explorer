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
           speciesName = species.name.lowercase(),
           classification = species.classification.lowercase(),
           designation = species.designation.lowercase(),
           average_height = species.average_height.lowercase(),
           skin_colors = species.skin_colors.lowercase(),
           hair_colors = species.hair_colors.lowercase(),
           eye_colors = species.eye_colors.lowercase(),
           average_lifespan = species.average_lifespan.lowercase(),
           homeworld = species.homeworld,
           language = species.language.lowercase(),
           url = species.url,
           speciesImage = ""
       )
        return speciesEntity

    }

}