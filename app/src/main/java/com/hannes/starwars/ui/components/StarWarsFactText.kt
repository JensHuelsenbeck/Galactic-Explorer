package com.hannes.starwars.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.hannes.starwars.ui.theme.starwarsfont
import com.hannes.starwars.ui.viewmodel.HomescreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun StarWarsFactText(
    modifier: Modifier = Modifier, viewModel: HomescreenViewModel = koinViewModel()
) {
    val randomFact by viewModel.randomFact.collectAsState()

    Text(
        text = randomFact,
        fontFamily = starwarsfont,
        modifier = modifier.padding(8.dp),
        textAlign = TextAlign.Center
    )
}