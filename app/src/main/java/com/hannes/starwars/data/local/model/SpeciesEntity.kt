package com.hannes.starwars.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "species")
data class SpeciesEntity(

    @PrimaryKey
    val speciesId: String = "",
    val speciesName: String,
    val classification: String,
    val designation: String,
    val average_height: String,
    val skin_colors: String,
    val hair_colors: String,
    val eye_colors: String,
    val average_lifespan: String,
    val homeworld: String?,
    val language: String,

    val url: String,

    val speciesImage: String?
)