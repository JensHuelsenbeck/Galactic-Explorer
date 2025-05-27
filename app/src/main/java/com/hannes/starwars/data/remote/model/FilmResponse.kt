package com.hannes.starwars.data.remote.model

import com.hannes.starwars.data.model.Film

class FilmResponse (
    val count: Int,
    val results: List<Film>
)