package com.hannes.starwars.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.hannes.starwars.R
import com.hannes.starwars.data.local.StarWarsDataBase
import com.hannes.starwars.data.model.Character
import com.hannes.starwars.data.model.Film
import com.hannes.starwars.data.model.FilmEntity
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
        insertDataToDatabase()
    }


    fun getAllDataFromApi() {
        viewModelScope.launch {
            try {
                val filmResponse = filmRepository.getMovies()
                _movies.value = filmResponse
                Log.d("Movies", "Movies: ${filmResponse.first()}}")
                val planetResponse = planetRepository.getPlanets()
                _planets.value = planetResponse
                Log.d("Planets", "Planets: ${planetResponse.first()}")
                val characterResponse = characterRepository.getCharacters()
                _characters.value = characterResponse
                Log.d("Characters", "Characters: ${characterResponse.first()}")
                val speciesResponse = speciesRepository.getSpecies()
                _species.value = speciesResponse
                Log.d("Species", "Species: ${speciesResponse.first()}")
            } catch (e: Exception) {
                Log.e("ERROR", "Error while trying to insert favorite meal ${e.localizedMessage}")
            }
        }
    }

    fun insertDataToDatabase() {
        viewModelScope.launch {
            delay(3000)
        movies.value.forEach { movie ->
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
                filmDao.insert(filmEntity)
                Log.d("Database", "Data inserted into database")

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


