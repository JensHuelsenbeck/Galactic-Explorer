package com.hannes.starwars.data.remote.model

import com.hannes.starwars.data.model.Species

class SpeciesResponse (
    val count: Int,
    val results: List<Species>
)
