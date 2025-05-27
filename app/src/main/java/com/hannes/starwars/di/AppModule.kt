package com.hannes.starwars.di

import com.hannes.starwars.data.remote.ApiService
import com.hannes.starwars.data.remote.StarWarsAPI
import com.hannes.starwars.data.repository.movieRepo.MovieRepository
import com.hannes.starwars.data.repository.movieRepo.MovieRepositoryInterface
import com.hannes.starwars.ui.viewmodel.HomescreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {

    single<MovieRepositoryInterface> {
        MovieRepository(
            get<ApiService>()
        )
    }

    single {
        StarWarsAPI.retrofitService
    }


    viewModelOf(::HomescreenViewModel)

}
