package com.hannes.starwars.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomeRoute{
    const val HOME_ROUTE = "home"
}

@Serializable
data class DetailsRoute(
    val type: String,
    val data: String
)

