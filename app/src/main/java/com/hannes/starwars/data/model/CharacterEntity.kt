package com.hannes.starwars.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "character")
data class CharacterEntity(

    @PrimaryKey(autoGenerate = true)
    val name: String,
    val height: String,
    val mass: String,
    val hair_color: String,
    val skin_color: String,
    val eye_color: String,
    val birth_year: String,
    val gender: String,
    val homeworld: String,
    val films: List<Film>?,
    val species: List<Species>?,
    val created: String,
    val edited: String,
    val url: String,

    val characterImage: String?
)