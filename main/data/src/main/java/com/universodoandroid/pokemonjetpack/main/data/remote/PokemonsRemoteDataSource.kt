package com.universodoandroid.pokemonjetpack.main.data.remote

import com.universodoandroid.pokemonjetpack.main.data.remote.reponse.PokemonsResponse
import kotlinx.coroutines.flow.Flow

interface PokemonsRemoteDataSource {
    fun getPokemons(): Flow<PokemonsResponse>
}