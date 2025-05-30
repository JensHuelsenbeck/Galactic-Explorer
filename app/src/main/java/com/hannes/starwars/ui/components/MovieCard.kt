package com.hannes.starwars.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hannes.starwars.R
import com.hannes.starwars.data.local.model.FilmEntity
import com.hannes.starwars.ui.theme.starWarsOrange
import com.hannes.starwars.ui.theme.starwarsfont
import com.hannes.starwars.ui.viewmodel.HomescreenViewModel
import org.koin.androidx.compose.koinViewModel


fun extractYearFromDate(dateString: String): String {
    return dateString.take(4)
}


@Composable
fun MovieCard(
    movie: FilmEntity,
    modifier: Modifier = Modifier,
    viewModel: HomescreenViewModel = koinViewModel()
) {
    Card(
        modifier = modifier
            .padding(vertical = 4.dp)
            .padding(horizontal = 6.dp)
            .fillMaxWidth()
            .width(275.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1C1C1E)
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {

            Image(
                painter = painterResource(movie.filmImage ?: R.drawable.starwars_logo),
                contentDescription = "Film Poster",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .height(150.dp),

                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Episode ${viewModel.episodeNumb(movie)}",
                fontSize = 20.sp,
                color = starWarsOrange,
                fontFamily = starwarsfont
            )
            Row(verticalAlignment = Alignment.Bottom) {
                Text(
                    text = movie.title,
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = extractYearFromDate(movie.release_date),
                    color = Color.Gray,
                    fontSize = 16.sp
                )
            }
        }
    }
}