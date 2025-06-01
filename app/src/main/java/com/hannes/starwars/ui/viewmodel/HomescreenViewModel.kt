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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.core.content.edit

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


    val filmEntities: StateFlow<List<FilmEntity>> = filmDao.getAllFilms().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = emptyList()
        )
    val characterEntities: StateFlow<List<CharacterEntity>> =
        characterDao.getAllICharacters().stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(),
                initialValue = emptyList()
            )
    val planetEntities: StateFlow<List<PlanetEntity>> = planetDao.getAllPlanets().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = emptyList()
        )
    val speciesEntities: StateFlow<List<SpeciesEntity>> = speciesDao.getAllISpecies().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = emptyList()
        )

    private val starWarsFacts = listOf(
        // Ursprüngliche 5
        "In the original novelization, Obi-Wan Kenobi's name was spelled 'Ben Kenobi'.",
        "Yoda’s species name has never been revealed in any official canon material.",
        "Star Wars was originally called 'The Adventures of Luke Starkiller'.",
        "Chewbacca's voice is a mix of bears, walruses and badgers recorded at the San Diego Zoo.",
        "The Wilhelm scream (a famous stock sound effect) appears in several Star Wars films.",
        "The iconic opening crawl text in “A New Hope” was initially written by George Lucas as a prologue to the film’s novelization.",
        "The sound of a lightsaber igniting was created by blending the hum of an old film projector with the buzz of an idle television set.",
        "R2-D2’s original name in early drafts was “Artoo-Detoo.”",
        "Jabba the Hutt was originally envisioned as a large, slug-like creature in “Return of the Jedi,” but concept art began as a giant, hairy monster before settling on his final design.",
        "Boba Fett’s first on-screen appearance was actually an animated sequence in the 1978 “Star Wars Holiday Special,” not in the original trilogy.",
        "The planet name “Tatooine” is derived from “Tatouine,” a real-life town in southern Tunisia, where many desert scenes were shot.",
        "Yoda was almost played by an actual monkey wearing a mask, but the idea was abandoned because it was too hard to control on set.",
        "In “The Empire Strikes Back,” Mark Hamill’s character mistakenly yells “Nooo!” when Luke’s hand is cut off; other actors were so good that George Lucas kept their takes, even when they flubbed lines.",
        "Admiral Ackbar’s famous line “It’s a trap!” was voiced by Erik Bauersfeld, who was recording at Lucasfilm for an unrelated project when he was asked to read the line.",
        "The Millennium Falcon’s distinct shape was inspired by a hamburger with an olive skewered on the side.",
        "The phrase “These aren’t the droids you’re looking for” was improvised by Harrison Ford during filming, and the stormtroopers’ reaction was genuine confusion.",
        "The Wookiee roar (Chewbacca’s voice) was a combination of recordings from bears, lions, tigers, and walruses.",
        "In “The Force Awakens,” Rian Johnson originally planned to reveal Snoke’s origins, but ultimately left it mysterious to preserve the character’s mystique.",
        "In “Revenge of the Sith,” Emperor Palpatine’s eyes turn yellow as a reference to his embrace of the dark side, mirroring how Sith apprentices’ eyes change in “The Phantom Menace.”",
        "The name “Vader” is derived from the Dutch word for “father” (“vader”), hinting at his eventual relationship to Luke and Leia.",
        "The original Ewok costumes in “Return of the Jedi” were made with real bearskins (tanned and processed to be safe for actors).",
        "The sound effect for the TIE fighters in the original trilogy is a mixture of an elephant bellow and a car driving on wet pavement.",
        "The ice planet Hoth was filmed in Finse, Norway, where temperatures dipped to –20 °C (–4 °F) during production.",
        "The Jawa masks were made from the lower halves of some World War II fighter pilot helmets.",
        "In early drafts, Han Solo was a large, green-skinned alien, not a human smuggler.",
        "George Lucas originally intended for Yoda to be played by a monkey in a mask, but the monkey kept stealing takes and couldn’t hit marks.",
        "The Emperor’s throne room in “Return of the Jedi” was filled with skeletons that were left over from the “Indiana Jones” films.",
        "The roar of the Sarlacc pit (in “Return of the Jedi”) is actually the pitched-down sound of a lion’s roar.",
        "The binary sunset scene on Tatooine (“Cantina” scene) used a recording of a Welsh male voice choir to provide the choir-like hum behind the music.",
        "In the original novelization, Luke Skywalker’s surname was spelled “Starkiller.”",
        "Samuel L. Jackson requested a purple lightsaber so that he could easily spot himself in group action scenes.",
        "In “Solo: A Star Wars Story,” Lando’s droid L3-37 is voiced by Phoebe Waller-Bridge, who improvised much of the character’s dialogue.",
        "The original name for Chewbacca was “Maro,” and he was at one point going to be a robot.",
        "The name “Endor” (the forest moon) comes from a Jewish legend in the Bible (the Witch of Endor).",
        "The phrase “May the Force be with you” appears in every single Star Wars film except “Solo: A Star Wars Story.”",
    )

    private val _randomFact = MutableStateFlow<String>("")
    val randomFact: StateFlow<String> = _randomFact

    init {
        getAllDataFromApi()

        // von ChatGPT erstellt
        viewModelScope.launch {
            val prefs = getApplication<Application>().getSharedPreferences(
                    "starwars_prefs",
                    Application.MODE_PRIVATE
                )

            val firstLaunch = withContext(Dispatchers.IO) {
                prefs.getBoolean("first_launch", true)
            }

            if (firstLaunch) {
                _randomFact.value = "press on any movie to see its details."

                withContext(Dispatchers.IO) {
                    prefs.edit { putBoolean("first_launch", false) }
                }
            } else {
                _randomFact.value = starWarsFacts.random()
            }
        }
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
        var episodeNum = when (movie.episode_id) {
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

    @OptIn(ExperimentalCoroutinesApi::class)
    val planetEntitiesforFilm: StateFlow<List<PlanetEntity>> =
        _selectedFilmTitle.filterNotNull().flatMapLatest { title ->
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
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(),
                initialValue = emptyList()
            )

    @OptIn(ExperimentalCoroutinesApi::class)
    val characterEntitiesForFilm: StateFlow<List<CharacterEntity>> =
        _selectedFilmTitle.filterNotNull().flatMapLatest { title ->
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
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(),
                initialValue = emptyList()
            )

    @OptIn(ExperimentalCoroutinesApi::class)
    val speciesEntitiesforFilm: StateFlow<List<SpeciesEntity>> =
        _selectedFilmTitle.filterNotNull().flatMapLatest { title ->
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
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(),
                initialValue = emptyList()
            )


    fun onFilmCardClicked(title: String) {
        _selectedFilmTitle.value = title
    }


}



