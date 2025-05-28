package com.hannes.starwars.data.repository.movieRepo

import com.hannes.starwars.data.model.Film

interface FilmRepositoryInterface {
    suspend fun getMovies(): List<Film>
}