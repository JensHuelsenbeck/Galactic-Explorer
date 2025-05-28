package com.hannes.starwars.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "films")
data class FilmEntity(

    @PrimaryKey(autoGenerate = true)
    val title: String,
    val episode_id: Int,
    val opening_crawl: String,
    val director: String,
    val producer: String,
    val release_date: String,
    val characters: List<Character>?,
    val planets: List<Planet>?,
    val species: List<Species>?,
    val created: String,
    val edited: String,
    val url: String,

    val filmImage: String?


)