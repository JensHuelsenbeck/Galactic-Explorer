package com.hannes.starwars.ui.screens

import android.app.Application
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hannes.starwars.navigation.DetailsRoute
import com.hannes.starwars.navigation.HomeRoute
import com.hannes.starwars.ui.theme.StarWarsTheme
import com.hannes.starwars.ui.viewmodel.HomescreenViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppStart(modifier: Modifier = Modifier) {
    val application = LocalContext.current.applicationContext as Application

    val navcontroller = rememberNavController()
    val navBackStackEntry by navcontroller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    StarWarsTheme {
        Scaffold(
            topBar = {
                if (currentRoute != HomeRoute.HOME_ROUTE) {
                    TopAppBar(
                        title = { Text("Details") },
                        navigationIcon = {
                            IconButton(onClick = {
                                navcontroller.popBackStack()
                            }) {
                                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                            }
                        }
                    )
                }
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        navcontroller.navigate(HomeRoute.HOME_ROUTE) {
                            popUpTo(0)
                            launchSingleTop = true
                        }
                    }
                ) {
                    Icon(Icons.Default.Home, contentDescription = "Go Home")
                }
            }
        ) { innerPadding ->
            NavHost(
                navController = navcontroller,
                startDestination = HomeRoute.HOME_ROUTE,
                modifier = Modifier.padding(innerPadding),
            )
            {


                composable(route = HomeRoute.HOME_ROUTE) {
                    HomeScreen(navController = navcontroller)
                }

                composable<DetailsRoute> { backStackEntry ->
                    val args = backStackEntry.arguments
                    val type = args?.getString("type") ?: ""
                    val data = args?.getString("data") ?: ""
                    val viewModel: HomescreenViewModel = koinViewModel()

                    when (type) {
                        "movie" -> {
                            val movie = viewModel.filmEntities.collectAsState().value.firstOrNull {
                                it.title == data
                            }
                            movie?.let {
                                MovieDetailScreen(movie = it,navController = navcontroller)
                            }
                        }
                        "species" -> {
                            val species = viewModel.speciesEntities.collectAsState().value
                                .firstOrNull { it.speciesName == data }
                            species?.let {
                                SpeciesScreen(species = it)
                            }
                        }
                        "planet" -> {
                            val planet = viewModel.planetEntities.collectAsState().value
                                .firstOrNull { it.planetName == data }
                            planet?.let {
                                PlanetDetailScreen(planet = it)
                            }
                        }
                        "character" -> {
                            val character = viewModel.characterEntities.collectAsState().value
                                .firstOrNull { it.characterName == data }
                            character?.let {
                                CharacterDetailScreen(char = it)
                            }
                        }
                    }
                }
            }
        }
    }
}