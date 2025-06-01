package com.hannes.starwars.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hannes.starwars.navigation.DetailsRoute
import com.hannes.starwars.ui.components.CharacterList
import com.hannes.starwars.ui.components.Header
import com.hannes.starwars.ui.components.MovieRow
import com.hannes.starwars.ui.components.PlanetList
import com.hannes.starwars.ui.components.SpeciesList
import com.hannes.starwars.ui.viewmodel.HomescreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomescreenViewModel = koinViewModel(),
    navController: NavHostController,
    modifier: Modifier = Modifier
) {


    val films = viewModel.filmEntities.collectAsState()
    val planets = viewModel.planetEntities.collectAsState()
    val characters = viewModel.characterEntities.collectAsState()
    val species = viewModel.speciesEntities.collectAsState()

    val planetsForFilm = viewModel.planetEntitiesforFilm.collectAsState()
    val charactersForFilm = viewModel.characterEntitiesForFilm.collectAsState()
    val speciesForFilm = viewModel.speciesEntitiesforFilm.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        Spacer(Modifier.height(8.dp))
        MovieRow(
            movieList = films.value,
            onMovieClick = { selectedMovie ->
                navController.navigate(DetailsRoute("movie", selectedMovie.title))
            }
        )
        Spacer(Modifier.height(8.dp))
        CharacterList(characterList = charactersForFilm.value)
        Spacer(Modifier.height(8.dp))
        PlanetList(
            planetList = planetsForFilm.value,
            onPlanetClick = { selectedPlanet ->
                navController.navigate(DetailsRoute("planet", selectedPlanet.planetName))
            }
        )
        Spacer(Modifier.height(8.dp))
        SpeciesList( speciesList = speciesForFilm.value,
            onSpeciesClick = { selectedSpecies ->
                navController.navigate(DetailsRoute("species", selectedSpecies.speciesName))
            })
    }
}
