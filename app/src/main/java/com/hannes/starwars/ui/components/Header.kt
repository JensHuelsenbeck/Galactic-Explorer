package com.hannes.starwars.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hannes.starwars.R
import com.hannes.starwars.ui.theme.basic
import com.hannes.starwars.ui.theme.starwarsfont

@Composable
fun Header(modifier: Modifier = Modifier) {

    Image(
        painter = painterResource(R.drawable.starwars_logo),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .size(100.dp)
    )
    Spacer(Modifier.height(20.dp))
    Text(
        text = "Galaxy Explorer",
        fontFamily = basic,
        style = MaterialTheme.typography.headlineSmall,
        color = Color.Yellow,
    )
    Text(
        text = "Galaxy Explorer",
        fontFamily = starwarsfont,
        color = Color.Yellow,
        fontSize = 17.sp
    )

}