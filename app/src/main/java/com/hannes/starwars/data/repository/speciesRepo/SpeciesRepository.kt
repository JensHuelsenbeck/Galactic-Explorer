package com.hannes.starwars.data.repository.speciesRepo

import com.hannes.starwars.data.local.model.SpeciesEntity
import com.hannes.starwars.data.model.Species
import com.hannes.starwars.data.remote.ApiService

class SpeciesRepository(
    private val apiService: ApiService
) : SpeciesRepositoryInterface {

    override suspend fun getSpecies(): List<Species> {
        val allSpecies = mutableListOf<Species>()
        var currentPage = 1
        var hasNext = true

        while (hasNext) {
            val response = apiService.getSpeciesByPage(currentPage)
            if (response.isSuccessful) {
                val body = response.body()
                val species = body?.results.orEmpty()
                allSpecies += species
                hasNext = body?.next != null
                currentPage++
            } else {
                throw Exception("API Error on page $currentPage: ${response.code()}")
            }
        }

        return allSpecies
    }

    fun extractIdFromUrl(url: String): String {
        return url.trimEnd('/').substringAfterLast('/')
    }

    override suspend fun createSpeciesEntity(species: Species): SpeciesEntity {
        return SpeciesEntity(
            speciesId = extractIdFromUrl(species.url),
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
    }
}