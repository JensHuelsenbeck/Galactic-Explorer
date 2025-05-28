package com.hannes.starwars.di

import com.hannes.starwars.data.remote.ApiService
import com.hannes.starwars.data.remote.StarWarsAPI
import com.hannes.starwars.data.repository.CharacterRepo.CharacterRepository
import com.hannes.starwars.data.repository.CharacterRepo.CharacterRepositoryInterface
import com.hannes.starwars.data.repository.movieRepo.FilmRepository
import com.hannes.starwars.data.repository.movieRepo.FilmRepositoryInterface
import com.hannes.starwars.data.repository.planetRepo.PlanetRepository
import com.hannes.starwars.data.repository.planetRepo.PlanetRepositoryInterface
import com.hannes.starwars.data.repository.speciesRepo.SpeciesRepository
import com.hannes.starwars.data.repository.speciesRepo.SpeciesRepositoryInterface
import com.hannes.starwars.ui.viewmodel.HomescreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {

    single<FilmRepositoryInterface> {
        FilmRepository(
            get<ApiService>()
        )
    }

    single<PlanetRepositoryInterface> {
        PlanetRepository(
            get<ApiService>()
        )
    }

    single<CharacterRepositoryInterface> {
        CharacterRepository(
            get<ApiService>()
        )
    }

    single<SpeciesRepositoryInterface> {
       SpeciesRepository(
            get<ApiService>()
        )
    }

    single {
        StarWarsAPI.retrofitService
    }


    viewModelOf(::HomescreenViewModel)

}
