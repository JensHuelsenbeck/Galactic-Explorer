package com.hannes.starwars.data.repository.movieRepo

import com.hannes.starwars.data.model.Film
import com.hannes.starwars.data.remote.ApiService


class MovieRepository(
    private val apiService: ApiService
) : MovieRepositoryInterface {
    override suspend fun getMovies(): List<Film> {
        val response = apiService.getAllFilms()
        if (response.isSuccessful) {
            return response.body()?.results ?: emptyList()
        } else {
            throw Exception("API Error: ${response.code()}")
        }
    }

}