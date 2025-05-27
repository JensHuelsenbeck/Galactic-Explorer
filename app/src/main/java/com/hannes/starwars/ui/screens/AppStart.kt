package com.hannes.starwars.ui.screens

import android.app.Application
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hannes.starwars.navigation.DetailsRoute
import com.hannes.starwars.navigation.HomeRoute
import com.hannes.starwars.ui.theme.StarWarsTheme

@Composable
fun AppStart(modifier: Modifier = Modifier) {
    val application = LocalContext.current.applicationContext as Application

    val navcontroller = rememberNavController()

    StarWarsTheme {
        Scaffold() { innerPadding ->
            NavHost(
                navController = navcontroller,
                startDestination = "home",
                modifier = Modifier.padding(innerPadding),
            )
            {


                composable<HomeRoute> {
                    HomeScreen(
                   //     onItemClick = { }
                    )
                }

                composable<DetailsRoute> { }

            }

        }
    }
}