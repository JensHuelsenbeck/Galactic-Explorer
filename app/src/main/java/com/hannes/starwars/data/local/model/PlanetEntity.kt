package com.hannes.starwars.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "planets")
data class PlanetEntity(

    @PrimaryKey
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