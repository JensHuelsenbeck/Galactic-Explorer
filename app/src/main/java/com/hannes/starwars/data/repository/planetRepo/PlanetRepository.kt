package com.hannes.starwars.data.repository.planetRepo

import com.hannes.starwars.data.local.model.PlanetEntity
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

    override suspend fun createPlanetEntity(planet: Planet): PlanetEntity {
        val planetEntity = PlanetEntity(
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