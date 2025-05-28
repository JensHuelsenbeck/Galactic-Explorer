package com.hannes.starwars.data.repository.planetRepo

import com.hannes.starwars.data.model.Film
import com.hannes.starwars.data.model.Planet
import com.hannes.starwars.data.remote.ApiService


class PlanetRepository(
    private val apiService: ApiService
) : PlanetRepositoryInterface {
    override suspend fun getPlanets(): List<Planet> {
        val response = apiService.getAllPlanets()
        if (response.isSuccessful) {
            return response.body()?.results ?: emptyList()
        } else {
            throw Exception("API Error: ${response.code()}")
        }
    }

}