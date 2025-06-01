package com.hannes.starwars.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import com.hannes.starwars.ui.components.StarWarsFactText
import com.hannes.starwars.ui.theme.starWarsOrange
import com.hannes.starwars.ui.theme.starwarsfont
import com.hannes.starwars.ui.viewmodel.HomescreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomescreenViewModel = koinViewModel(),
    navController: NavHostController
) {


    val films = viewModel.filmEntities.collectAsState()
    val planets = viewModel.planetEntities.collectAsState()
    val characters = viewModel.characterEntities.collectAsState()
    val species = viewModel.speciesEntities.collectAsState()

    val planetsForFilm = viewModel.planetEntitiesforFilm.collectAsState()
    val charactersForFilm = viewModel.characterEntitiesForFilm.collectAsState()
    val speciesForFilm = viewModel.speciesEntitiesforFilm.collectAsState()

    var showAll by rememberSaveable { mutableStateOf(true) }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        Spacer(Modifier.height(8.dp))
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = if (!showAll) "show all" else "show Movies",
                color = starWarsOrange,
                fontFamily = starwarsfont,
                modifier = modifier
                    .clickable(
                        onClick = { showAll = !showAll }
                    )
            )
        }
        if (!showAll) {
            MovieRow(
                movieList = films.value,
                onMovieClick = { selectedMovie ->
                    navController.navigate(DetailsRoute("movie", selectedMovie.title))
                }
            )
        }
        Spacer(Modifier.height(8.dp))
        CharacterList(
            characterList = if (!showAll) charactersForFilm.value else characters.value,
            onCharacterClick = { character ->
                navController.navigate(DetailsRoute("character", character.characterName))
            }
        )

        Spacer(Modifier.height(8.dp))
        PlanetList(
            planetList = if (!showAll) planetsForFilm.value else planets.value,
            onPlanetClick = { selectedPlanet ->
                navController.navigate(DetailsRoute("planet", selectedPlanet.planetName))
            }
        )
        Spacer(Modifier.height(8.dp))
        SpeciesList(
            speciesList = if (!showAll) speciesForFilm.value else species.value,
            onSpeciesClick = { selectedSpecies ->
                navController.navigate(DetailsRoute("species", selectedSpecies.speciesName))
            }
        )

        if (showAll) StarWarsFactText()
        Spacer(Modifier.weight(1f))
    }
}
