package com.hannes.starwars.data.repository.movieRepo


import com.hannes.starwars.data.model.Film
import com.hannes.starwars.data.local.model.FilmEntity

interface FilmRepositoryInterface {
    suspend fun getMovies(): List<Film>
    suspend fun movieIntoDb(movie: Film): FilmEntity
}