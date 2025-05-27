package com.hannes.starwars.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hannes.starwars.data.model.Film
import com.hannes.starwars.data.repository.movieRepo.MovieRepositoryInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomescreenViewModel(
    private val repository: MovieRepositoryInterface
): ViewModel() {

  private val _movies = MutableStateFlow<List<Film>>(emptyList())
    val movies = _movies.asStateFlow()

  init {
      getMovies()
  }


fun getMovies() {
    viewModelScope.launch {
        try {
            val response = repository.getMovies()
            _movies.value = response
        } catch (e: Exception) {
            Log.e("ERROR", "Error while trying to insert favorite meal ${e.localizedMessage}")
        }
    }
}

    fun episodeNumb(movie: Film): String {
        var episodeNum =
            when (movie.episode_id) {
                1 -> "i"
                2 -> "ii"
                3 -> "iii"
                4 -> "iv"
                5 -> "v"
                6 -> "vi"
                7 -> "vii"
                else -> ""
            }
        return episodeNum
    }

}