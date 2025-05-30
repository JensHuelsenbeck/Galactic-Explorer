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
            planetName = planet.name,
            rotation_period = planet.rotation_period,
            orbital_period = planet.orbital_period,
            diameter = planet.diameter,
            climate = planet.climate,
            gravity = planet.gravity,
            terrain = planet.terrain,
            surface_water = planet.surface_water,
            population = planet.population,
            url = planet.url,
            planetImage = ""
        )
        return planetEntity
    }

}