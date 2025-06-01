package com.hannes.starwars.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "planets")
data class PlanetEntity(

    @PrimaryKey
    val planetId: String = "",
    val planetName: String,
    val rotation_period: String,
    val orbital_period: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,
    val surface_water: String,
    val population: String,
    val url: String,
    val planetImage: String?
)