package com.hannes.starwars.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomeRoute
@Serializable
data class DetailsRoute(
    val type: String,
    val data: String
)