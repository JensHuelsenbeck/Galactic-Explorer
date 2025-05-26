package com.hannes.starwars.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.hannes.starwars.data.model.Film
import com.hannes.starwars.ui.theme.starwarsfont
import java.time.OffsetDateTime

fun episodeNumb(movie: Film): String {
    var episodeNum =
        when (movie.episode_id) {
            4 -> "iv"
            else -> ""
        }
    return episodeNum
}

fun extractYearFromDate(dateString: String): String {
    return dateString.take(4)
}


@Composable
fun MovieItem(
    movie: Film,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1C1C1E)
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            AsyncImage(
                model = movie.filmImage,
                contentDescription = "Film Poster",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Episode ${episodeNumb(movie)}",
                fontSize = 20.sp,
                color = Color.Yellow,
                fontFamily = starwarsfont
            )
            Text(
                text = movie.title,
                fontSize = 22.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = extractYearFromDate(movie.release_date),
                color = Color.Gray,
                fontSize = 16.sp
            )
        }
    }
}

