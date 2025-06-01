package com.hannes.starwars.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.hannes.starwars.R
import com.hannes.starwars.data.local.model.SpeciesEntity
import com.hannes.starwars.navigation.DetailsRoute
import com.hannes.starwars.ui.components.CharacterList
import com.hannes.starwars.ui.components.PlanetList
import com.hannes.starwars.ui.components.SpeciesList
import com.hannes.starwars.ui.theme.basic
import com.hannes.starwars.ui.theme.starWarsOrange
import com.hannes.starwars.ui.theme.starwarsfont
import com.hannes.starwars.ui.viewmodel.HomescreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SpeciesScreen(
    species: SpeciesEntity,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: HomescreenViewModel = koinViewModel()
) {
    val planets = viewModel.planetEntities.collectAsState()
    val characters = viewModel.characterEntities.collectAsState()
    val speciess = viewModel.speciesEntities.collectAsState()

    Column(
        modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.starwars_logo), contentDescription = null
        )
        Spacer(modifier.padding(vertical = 8.dp))
        Text(
            text = species.speciesName,
            fontFamily = basic,
            style = MaterialTheme.typography.headlineSmall,
            color = starWarsOrange,
        )
        Text(
            text = species.speciesName,
            fontFamily = starwarsfont,
            color = starWarsOrange,
            fontSize = 17.sp
        )
        Spacer(modifier.padding(vertical = 8.dp))

        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF1C1C1E)
            )
        ) {

            Text(
                text = "Character Details",
                fontFamily = starwarsfont,
                color = starWarsOrange,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(top = 8.dp)
            )


            Row(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            ) {

                Column {
                    Row {
                        Text(
                            text = "Classification: ",
                            color = starWarsOrange,

                            )
                        Text(
                            text = species.classification,
                        )
                    }
                    Row {
                        Text(
                            text = "Designation: ", color = starWarsOrange
                        )
                        Text(
                            text = species.designation,
                        )
                    }
                    Row {
                        Text(
                            text = "Height: ",
                            color = starWarsOrange,
                        )
                        Text(
                            text = "${species.average_height} cm",
                        )
                    }
                    Row {
                        Text(
                            text = "Livespan: ",
                            color = starWarsOrange,

                            )
                        Text(
                            text = "${species.average_lifespan} years",
                        )
                    }
                }
                Spacer(Modifier.weight(1f))
                Column {
                    Row {
                        Text(
                            text = "Language: ",
                            color = starWarsOrange,
                        )
                        Text(
                            text = species.language,
                        )
                    }
                    Row {
                        Text(
                            text = "Skin color: ",
                            color = starWarsOrange,
                        )
                        Text(
                            text = species.skin_colors,
                        )
                    }
                    Row {
                        Text(
                            text = "Hair color: ",
                            color = starWarsOrange,
                        )
                        Text(
                            text = species.hair_colors,
                        )
                    }
                    Row {
                        Text(
                            text = "Eye color: ",
                            color = starWarsOrange,

                            )
                        Text(
                            text = species.eye_colors
                        )
                    }
                }
                Spacer(Modifier.weight(1f))
            }
        }
        LazyColumn(modifier.padding(8.dp)) {
            item {
                CharacterList(
                    characterList = characters.value, onCharacterClick = { character ->
                        navController.navigate(DetailsRoute("character", character.characterName))
                    })
                Spacer(Modifier.height(8.dp))
                PlanetList(
                    planetList = planets.value, onPlanetClick = { selectedPlanet ->
                        navController.navigate(DetailsRoute("planet", selectedPlanet.planetName))
                    })
                Spacer(Modifier.height(8.dp))
                SpeciesList(
                    speciesList = speciess.value, onSpeciesClick = { selectedSpecies ->
                        navController.navigate(DetailsRoute("species", selectedSpecies.speciesName))
                    })
            }
        }
    }
}