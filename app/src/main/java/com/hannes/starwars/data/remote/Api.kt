package com.hannes.starwars.data.remote

import com.hannes.starwars.data.remote.model.CharacterResponse
import com.hannes.starwars.data.remote.model.FilmResponse
import com.hannes.starwars.data.remote.model.PlanetResponse
import com.hannes.starwars.data.remote.model.SpeciesResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://swapi.py4e.com/api/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val loggingInterceptor = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BASIC
}

private val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(loggingInterceptor)
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(okHttpClient)
    .build()

interface ApiService {

    @GET("films/")
    suspend fun getAllFilms(): Response<FilmResponse>

    @GET("people/")
    suspend fun getAllCharacters(): Response<CharacterResponse>

    @GET("planets/")
    suspend fun getAllPlanets(): Response<PlanetResponse>

    @GET("species/")
    suspend fun getAllSpecies(): Response<SpeciesResponse>
}

object StarWarsAPI {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

fun main() = kotlinx.coroutines.runBlocking {
    val api = StarWarsAPI.retrofitService

    val filmResponse = api.getAllFilms()
    println(" Total Films: ${filmResponse.body()?.results?.size}")

    val characterResponse = api.getAllCharacters()
    println(" Total Characters: ${characterResponse.body()?.results?.size}")

    val planetResponse = api.getAllPlanets()
    println(" Total Planets: ${planetResponse.body()?.results?.size}")

    val speciesResponse = api.getAllSpecies()
    println(" Total Species: ${speciesResponse.body()?.results?.size}")
}
