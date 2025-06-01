package com.hannes.starwars.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hannes.starwars.ui.theme.starWarsOrange
import com.hannes.starwars.ui.theme.starwarsfont

@Composable
fun ListItem(
    title: String,
    subTitle: String?,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    Card(
        Modifier
            .width(300.dp)
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .let { baseModifier ->
                if (onClick != null) baseModifier.clickable { onClick() } else baseModifier
            },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1C1C1E)
        )
    ) {
        Column(
            modifier
                .padding(vertical = 6.dp, horizontal = 8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                fontSize = 20.sp,
                color = starWarsOrange,
                fontFamily = starwarsfont
            )
            Spacer(Modifier.weight(1f))
            Text(
                text = subTitle ?: "",
                fontFamily = starwarsfont
            )
        }
    }
}