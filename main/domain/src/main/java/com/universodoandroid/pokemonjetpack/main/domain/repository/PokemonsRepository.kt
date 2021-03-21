package com.universodoandroid.pokemonjetpack.main.domain.repository

import com.universodoandroid.pokemonjetpack.main.domain.entity.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonsRepository {
     fun getPokemons(): Flow<List<Pokemon>>
}