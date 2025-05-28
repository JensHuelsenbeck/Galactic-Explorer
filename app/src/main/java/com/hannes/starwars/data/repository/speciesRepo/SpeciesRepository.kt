package com.hannes.starwars.data.repository.speciesRepo

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

}