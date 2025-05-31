package com.hannes.starwars.data.remote.model

import com.hannes.starwars.data.model.Species

class SpeciesResponse (
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Species>
)
