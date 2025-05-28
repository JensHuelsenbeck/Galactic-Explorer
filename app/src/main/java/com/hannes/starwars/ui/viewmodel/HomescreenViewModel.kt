package com.hannes.starwars.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hannes.starwars.data.model.Character
import com.hannes.starwars.data.model.Film
import com.hannes.starwars.data.model.Planet
import com.hannes.starwars.data.model.Species
import com.hannes.starwars.data.repository.CharacterRepo.CharacterRepositoryInterface
import com.hannes.starwars.data.repository.movieRepo.FilmRepositoryInterface
import com.hannes.starwars.data.repository.planetRepo.PlanetRepositoryInterface
import com.hannes.starwars.data.repository.speciesRepo.SpeciesRepositoryInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomescreenViewModel(
    private val filmRepository: FilmRepositoryInterface,
    private val planetRepository: PlanetRepositoryInterface,
    private val characterRepository: CharacterRepositoryInterface,
    private val speciesRepository: SpeciesRepositoryInterface
): ViewModel() {

  private val _movies = MutableStateFlow<List<Film>>(emptyList())
    val movies = _movies.asStateFlow()

    private val _planets = MutableStateFlow<List<Planet>>(emptyList())
    val planets = _planets.asStateFlow()

    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters = _characters.asStateFlow()

    private val _species = MutableStateFlow<List<Species>>(emptyList())
    val allSpecies = _species.asStateFlow()

  init {
      getAllData()
  }


fun getAllData() {
    viewModelScope.launch {
        try {
            val filmResponse = filmRepository.getMovies()
            _movies.value = filmResponse
            val planetResponse = planetRepository.getPlanets()
            _planets.value = planetResponse
            val characterResponse = characterRepository.getCharacters()
            _characters.value = characterResponse
            val speciesResponse = speciesRepository.getSpecies()
            _species.value = speciesResponse
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