package com.hannes.starwars.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.hannes.starwars.constants.idsForEpisode1
import com.hannes.starwars.constants.idsForEpisode2
import com.hannes.starwars.constants.idsForEpisode3
import com.hannes.starwars.constants.idsForEpisode4
import com.hannes.starwars.constants.idsForEpisode5
import com.hannes.starwars.constants.idsForEpisode6
import com.hannes.starwars.constants.idsForEpisode7
import com.hannes.starwars.data.local.StarWarsDataBase
import com.hannes.starwars.data.local.model.CharacterEntity
import com.hannes.starwars.data.local.model.FilmEntity
import com.hannes.starwars.data.local.model.PlanetEntity
import com.hannes.starwars.data.local.model.SpeciesEntity
import com.hannes.starwars.data.repository.CharacterRepo.CharacterRepositoryInterface
import com.hannes.starwars.data.repository.movieRepo.FilmRepositoryInterface
import com.hannes.starwars.data.repository.planetRepo.PlanetRepositoryInterface
import com.hannes.starwars.data.repository.speciesRepo.SpeciesRepositoryInterface
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
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


    /*
        private val _movies = MutableStateFlow<List<Film>>(emptyList())
        val movies = _movies.asStateFlow()

        private val _planets = MutableStateFlow<List<Planet>>(emptyList())
        val planets = _planets.asStateFlow()

        private val _characters = MutableStateFlow<List<Character>>(emptyList())
        val characters = _characters.asStateFlow()

        private val _species = MutableStateFlow<List<Species>>(emptyList())
        val allSpecies = _species.asStateFlow()
     */
    init {
        getAllDataFromApi()

    }


    fun getAllDataFromApi() {
        viewModelScope.launch {
            try {
                val filmResponse = filmRepository.getMovies()
                filmResponse.forEach { movie ->
                    filmDao.insert(filmRepository.movieIntoDb(movie))
                }
                Log.d("Movies", "Movies: ${filmResponse.first()}}")
                val planetResponse = planetRepository.getPlanets()
                planetResponse.forEach { planet ->
                    planetDao.insert(planetRepository.createPlanetEntity(planet))
                }
                Log.d("Planets", "Planets: ${planetResponse.first()}")
                Log.d("Planets", "Total planets loaded: ${planetResponse.size}")
                val characterResponse = characterRepository.getCharacters()
                characterResponse.forEach { character ->
                    characterDao.insert(characterRepository.createCharacterEntity(character))
                }
                Log.d("Characters", "Characters: ${characterResponse.first()}")
                Log.d("Characters", "Total characters loaded: ${characterResponse.size}")
                val speciesResponse = speciesRepository.getSpecies()
                speciesResponse.forEach { species ->
                    speciesDao.insert(speciesRepository.createSpeciesEntity(species))
                }
                Log.d("Species", "Species: ${speciesResponse.first()}")
                Log.d("Species", "Total species loaded: ${speciesResponse.size}")

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

    private val _selectedFilmTitle = MutableStateFlow<String?>(null)

    val planetEntitiesforFilm: StateFlow<List<PlanetEntity>> = _selectedFilmTitle
        .filterNotNull()
        .flatMapLatest { title ->
            when (title) {
                "The Phantom Menace" -> {
                    planetDao.getPlanetsForFilm(ids = idsForEpisode1.planetIds)
                }
                "Attack of the Clones" -> {
                    planetDao.getPlanetsForFilm(ids = idsForEpisode2.planetIds)
                }
                "Revenge of the Sith" -> {
                    planetDao.getPlanetsForFilm(ids = idsForEpisode3.planetIds)
                }
                "A New Hope" -> {
                    planetDao.getPlanetsForFilm(ids = idsForEpisode4.planetIds)
                }
                "The Empire Strikes Back" -> {
                    planetDao.getPlanetsForFilm(ids = idsForEpisode5.planetIds)
                }
                "Return of the Jedi" -> {
                    planetDao.getPlanetsForFilm(ids = idsForEpisode6.planetIds)
                }
                "The Force Awakens" -> {
                    planetDao.getPlanetsForFilm(ids = idsForEpisode7.planetIds)
                }
                else -> flowOf(emptyList())
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = emptyList()
        )

    val characterEntitiesForFilm: StateFlow<List<CharacterEntity>> = _selectedFilmTitle
        .filterNotNull()
        .flatMapLatest { title ->
            when (title) {
                "The Phantom Menace" -> {
                    characterDao.getCharactersForFilm(ids = idsForEpisode1.characterIds)
                }
                "Attack of the Clones" -> {
                    characterDao.getCharactersForFilm(ids = idsForEpisode2.characterIds)
                }
                "Revenge of the Sith" -> {
                    characterDao.getCharactersForFilm(ids = idsForEpisode3.characterIds)
                }
                "A New Hope" -> {
                    characterDao.getCharactersForFilm(ids = idsForEpisode4.characterIds)
                }
                "The Empire Strikes Back" -> {
                    characterDao.getCharactersForFilm(ids = idsForEpisode5.characterIds)
                }

                "Return of the Jedi" -> {
                    characterDao.getCharactersForFilm(ids = idsForEpisode6.characterIds)
                }
                "The Force Awakens" -> {
                    characterDao.getCharactersForFilm(ids = idsForEpisode7.characterIds)
                }
                else -> flowOf(emptyList())
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = emptyList()
        )

    val speciesEntitiesforFilm: StateFlow<List<SpeciesEntity>> = _selectedFilmTitle
        .filterNotNull()
        .flatMapLatest { title ->
            when (title) {
                "The Phantom Menace" -> {
                    speciesDao.getSpeciesForFilm(ids = idsForEpisode1.speciesIds)
                }
                "Attack of the Clones" -> {
                    speciesDao.getSpeciesForFilm(ids = idsForEpisode2.speciesIds)
                }
                "Revenge of the Sith" -> {
                    speciesDao.getSpeciesForFilm(ids = idsForEpisode3.speciesIds)
                }
                "A New Hope" -> {
                    speciesDao.getSpeciesForFilm(ids = idsForEpisode4.speciesIds)
                }
                "The Empire Strikes Back" -> {
                    speciesDao.getSpeciesForFilm(ids = idsForEpisode5.speciesIds)
                }
                "Return of the Jedi" -> {
                    speciesDao.getSpeciesForFilm(ids = idsForEpisode6.speciesIds)
                }
                "The Force Awakens" -> {
                    speciesDao.getSpeciesForFilm(ids = idsForEpisode7.speciesIds)
                }
                else -> flowOf(emptyList())
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = emptyList()
        )


    fun onFilmCardClicked(title: String) {
        _selectedFilmTitle.value = title
    }
}



