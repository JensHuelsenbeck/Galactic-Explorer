package com.hannes.starwars.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.hannes.starwars.ui.theme.basic
import com.hannes.starwars.ui.theme.starwarsfont

@Composable
fun CategoryTitle(
    text: String,
    modifier: Modifier = Modifier
) {
    Row(verticalAlignment = Alignment.Bottom,
        modifier = modifier) {
        Text(
            text = text,
            fontFamily = basic,
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Yellow,
        )
        Text(
            text = " $text",
            fontFamily = starwarsfont,
            color = Color.Yellow,
            style = MaterialTheme.typography.bodyLarge,
        )
        Spacer(Modifier.weight(1f))
    }
}