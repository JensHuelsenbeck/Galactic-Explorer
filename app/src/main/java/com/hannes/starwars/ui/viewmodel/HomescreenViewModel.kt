package com.hannes.starwars.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.hannes.starwars.data.local.StarWarsDataBase
import com.hannes.starwars.data.local.model.CharacterEntity
import com.hannes.starwars.data.model.Character
import com.hannes.starwars.data.model.Film
import com.hannes.starwars.data.local.model.FilmEntity
import com.hannes.starwars.data.local.model.PlanetEntity
import com.hannes.starwars.data.local.model.SpeciesEntity
import com.hannes.starwars.data.model.Planet
import com.hannes.starwars.data.model.Species
import com.hannes.starwars.data.repository.CharacterRepo.CharacterRepositoryInterface
import com.hannes.starwars.data.repository.movieRepo.FilmRepositoryInterface
import com.hannes.starwars.data.repository.planetRepo.PlanetRepositoryInterface
import com.hannes.starwars.data.repository.speciesRepo.SpeciesRepositoryInterface
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn

import kotlinx.coroutines.launch
import kotlin.collections.forEach

class HomescreenViewModel(
    private val filmRepository: FilmRepositoryInterface,
    private val planetRepository: PlanetRepositoryInterface,
    private val characterRepository: CharacterRepositoryInterface,
    private val speciesRepository: SpeciesRepositoryInterface,
    application: Application
) : AndroidViewModel(application) {

    private val filmDao = StarWarsDataBase.getDatabase(application.applicationContext).filmDao()
    private val planetDao = StarWarsDataBase.getDatabase(application.applicationContext).planetDao()
    private val characterDao =
        StarWarsDataBase.getDatabase(application.applicationContext).characterDao()
    private val speciesDao =
        StarWarsDataBase.getDatabase(application.applicationContext).speciesDao()


    val filmEntities: StateFlow<List<FilmEntity>> = filmDao.getAllFilms()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = emptyList()
        )
    val characterEntities: StateFlow<List<CharacterEntity>> = characterDao.getAllICharacters()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = emptyList()
        )
    val planetEntities: StateFlow<List<PlanetEntity>> = planetDao.getAllPlanets()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = emptyList()
        )
    val speciesEntities: StateFlow<List<SpeciesEntity>> = speciesDao.getAllISpecies()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = emptyList()
        )

    private val _movies = MutableStateFlow<List<Film>>(emptyList())
    val movies = _movies.asStateFlow()

    private val _planets = MutableStateFlow<List<Planet>>(emptyList())
    val planets = _planets.asStateFlow()

    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters = _characters.asStateFlow()

    private val _species = MutableStateFlow<List<Species>>(emptyList())
    val allSpecies = _species.asStateFlow()

    init {
        getAllDataFromApi()

    }


    fun getAllDataFromApi() {
        viewModelScope.launch {
            try {
                val filmResponse = filmRepository.getMovies()
                _movies.value = filmResponse
                filmResponse.forEach { movie ->
                    filmDao.insert(filmRepository.movieIntoDb(movie))
                }

                Log.d("Movies", "Movies: ${filmResponse.first()}}")
                val planetResponse = planetRepository.getPlanets()
                _planets.value = planetResponse
                planetResponse.forEach { planet ->
                    planetDao.insert(planetRepository.createPlanetEntity(planet))
                }
                Log.d("Planets", "Planets: ${planetResponse.first()}")
                val characterResponse = characterRepository.getCharacters()
                _characters.value = characterResponse
                characterResponse.forEach { character ->
                    characterDao.insert(characterRepository.createCharacterEntity(character))
                }
                Log.d("Characters", "Characters: ${characterResponse.first()}")
                val speciesResponse = speciesRepository.getSpecies()
                _species.value = speciesResponse
                speciesResponse.forEach { species ->
                    speciesDao.insert(speciesRepository.createSpeciesEntity(species))
                    Log.d("Species", "Species: ${speciesResponse.first()}")
                }
            } catch (e: Exception) {
                Log.e("ERROR", "Error while fetching from API:  ${e.localizedMessage}")
            }
        }
    }


    fun episodeNumb(movie: FilmEntity): String {
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


