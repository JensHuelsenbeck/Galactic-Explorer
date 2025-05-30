package com.hannes.starwars.data.repository.planetRepo

import com.hannes.starwars.data.local.model.PlanetEntity
import com.hannes.starwars.data.model.Film
import com.hannes.starwars.data.model.Planet

interface PlanetRepositoryInterface {
    suspend fun getPlanets(): List<Planet>
    suspend fun createPlanetEntity(planet: Planet): PlanetEntity
}