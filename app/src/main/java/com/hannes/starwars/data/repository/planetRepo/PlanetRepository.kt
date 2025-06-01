package com.hannes.starwars.data.repository.planetRepo

import com.hannes.starwars.data.local.model.PlanetEntity
import com.hannes.starwars.data.model.Planet
import com.hannes.starwars.data.remote.ApiService


class PlanetRepository(
    private val apiService: ApiService
) : PlanetRepositoryInterface {
    override suspend fun getPlanets(): List<Planet> {
        val allPlanets = mutableListOf<Planet>()
        var currentPage = 1
        var hasNext = true

        while (hasNext) {
            val response = apiService.getPlanetsByPage(currentPage)
            if (response.isSuccessful) {
                val body = response.body()
                val planets = body?.results ?: emptyList()
                allPlanets += planets
                hasNext = body?.next != null
                currentPage++
            } else {
                throw Exception("API Error on page $currentPage: ${response.code()}")
            }
        }

        return allPlanets
    }

    fun extractIdFromUrl(url: String): String {
        return url.trimEnd('/').substringAfterLast('/')
    }

    override suspend fun createPlanetEntity(planet: Planet): PlanetEntity {
        val planetEntity = PlanetEntity(
            planetId = extractIdFromUrl(planet.url),
            planetName = planet.name.lowercase(),
            rotation_period = planet.rotation_period.lowercase(),
            orbital_period = planet.orbital_period.lowercase(),
            diameter = planet.diameter.lowercase(),
            climate = planet.climate.lowercase(),
            gravity = planet.gravity.lowercase(),
            terrain = planet.terrain.lowercase(),
            surface_water = planet.surface_water.lowercase(),
            population = planet.population.lowercase(),
            url = planet.url,
            planetImage = ""
        )
        return planetEntity
    }

}