package com.hannes.starwars.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "films")
data class FilmEntity(

    @PrimaryKey
    val filmId: String = "",
    val episode_id: Int,
    val title: String,
    val opening_crawl: String,
    val director: String,
    val producer: String,
    val release_date: String,

    val url: String,

    val filmImage: Int?


)