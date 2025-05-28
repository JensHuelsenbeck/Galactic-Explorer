package com.hannes.starwars.data.repository.CharacterRepo

import com.hannes.starwars.data.model.Character
import com.hannes.starwars.data.model.Planet
import com.hannes.starwars.data.remote.ApiService


class CharacterRepository(
    private val apiService: ApiService
) : CharacterRepositoryInterface {
    override suspend fun getCharacters(): List<Character> {
        val response = apiService.getAllCharacters()
        if (response.isSuccessful) {
            return response.body()?.results ?: emptyList()
        } else {
            throw Exception("API Error: ${response.code()}")
        }
    }

}