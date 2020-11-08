package com.universodoandroid.pokemonjetpack.main.domain.repository

import com.universodoandroid.pokemonjetpack.main.domain.entity.Pokemon

interface PokemonsRepository {
    suspend fun getPokemons(): List<Pokemon>
}