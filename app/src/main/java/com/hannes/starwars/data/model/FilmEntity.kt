package com.hannes.starwars.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "films")
data class FilmEntity(

    @PrimaryKey
    val filmId: String = UUID.randomUUID().toString(),
    val title: String,
    val episode_id: Int,
    val opening_crawl: String,
    val director: String,
    val producer: String,
    val release_date: String,
    val characters: List<String>?,
    val planets: List<String>?,
    val species: List<String>?,
    val created: String,
    val edited: String,
    val url: String,

    val filmImage: String?


)