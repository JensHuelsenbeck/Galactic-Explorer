package com.hannes.starwars.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "characters")
data class CharacterEntity(

    @PrimaryKey
    val characterName: String,
    val height: String,
    val mass: String,
    val hair_color: String,
    val skin_color: String,
    val eye_color: String,
    val birth_year: String,
    val gender: String,
    val homeworld: String,
    val url: String,
    val characterImage: String?
)