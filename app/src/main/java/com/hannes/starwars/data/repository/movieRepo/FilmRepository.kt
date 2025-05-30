package com.hannes.starwars.data.repository.movieRepo

import android.util.Log
import com.hannes.starwars.R
import com.hannes.starwars.data.local.model.FilmEntity
import com.hannes.starwars.data.model.Film
import com.hannes.starwars.data.remote.ApiService
import kotlinx.coroutines.delay


class FilmRepository(
    private val apiService: ApiService
) : FilmRepositoryInterface {
    override suspend fun getMovies(): List<Film> {
        val response = apiService.getAllFilms()
        if (response.isSuccessful) {
            return response.body()?.results ?: emptyList()
        } else {
            throw Exception("API Error: ${response.code()}")
        }
    }

    override suspend fun movieIntoDb(movie: Film): FilmEntity {
        Log.d("Database", "Inserting movie: $movie")
        val filmEntity = FilmEntity(
            title = movie.title,
            episode_id = movie.episode_id,
            opening_crawl = movie.opening_crawl,
            director = movie.director,
            producer = movie.producer,
            release_date = movie.release_date,
            url = movie.url,
            filmImage =
                when (movie.episode_id) {
                    1 -> R.drawable.episode1
                    2 -> R.drawable.episode2
                    3 -> R.drawable.episode3
                    4 -> R.drawable.episode4
                    5 -> R.drawable.episode5
                    6 -> R.drawable.episode6
                    7 -> R.drawable.episode7
                    else -> null
                }
        )
        Log.d("Database", "Data inserted into database")
        return filmEntity
    }
}