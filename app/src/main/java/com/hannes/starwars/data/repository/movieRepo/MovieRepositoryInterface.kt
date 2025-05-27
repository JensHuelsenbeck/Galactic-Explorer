package com.hannes.starwars.data.repository.movieRepo

import com.hannes.starwars.data.model.Film

interface MovieRepositoryInterface {
    suspend fun getMovies(): List<Film>
}