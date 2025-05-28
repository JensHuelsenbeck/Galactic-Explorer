package com.hannes.starwars.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "planets")
data class PlanetEntity(

    @PrimaryKey(autoGenerate = true)
    val name: String,
    val rotation_period: String,
    val orbital_period: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,
    val surface_water: String,
    val population: String,
    val residents: List<Character>?,
    val films: List<Film>?,
    val created: String,
    val edited: String,
    val url: String,

    val planetImage: String?
)