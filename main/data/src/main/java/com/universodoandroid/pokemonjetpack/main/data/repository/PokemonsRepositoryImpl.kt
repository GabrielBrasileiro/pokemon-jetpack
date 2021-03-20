package com.universodoandroid.pokemonjetpack.main.data.repository

import com.universodoandroid.pokemonjetpack.main.domain.entity.Pokemon
import com.universodoandroid.pokemonjetpack.main.domain.repository.PokemonsRepository

internal class PokemonsRepositoryImpl : PokemonsRepository {

    override suspend fun getPokemons(): List<Pokemon> {
        return listOf(
            Pokemon("0", "Pikachu"),
            Pokemon("1", "Sharizard"),
        )
    }
}