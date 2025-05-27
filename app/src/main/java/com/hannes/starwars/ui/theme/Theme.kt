package com.hannes.starwars.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/*private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = globalBackground
)
*//*
primary = Primary,
onPrimary = Color.White,
primaryContainer = PrimaryContainerLight,
onPrimaryContainer = OnPrimaryContainerLight,
background = LightThemeBackground,
surface = SurfaceLight,
onSurface = Color.Black,
secondaryContainer = SecondaryContainerLight,
onSecondaryContainer = Color.Black
 *//*

private val LightColorScheme = lightColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = globalBackground

    *//* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    *//*
)*/

private val AppColorScheme = darkColorScheme(
    primary = starWarsOrange,
    onPrimary = OnPrimary,
    background = globalBackground,
    onBackground = OnBackground,
    surface = Surface,
    onSurface = OnSurface
)

@Composable
fun StarWarsTheme(content: @Composable () -> Unit) {

    MaterialTheme(
        colorScheme = AppColorScheme,
        typography = Typography,
        content = content
    )
}