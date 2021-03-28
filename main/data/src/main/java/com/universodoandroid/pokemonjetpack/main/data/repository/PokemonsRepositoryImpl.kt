package com.universodoandroid.pokemonjetpack.main.data.repository

import com.universodoandroid.pokemonjetpack.main.data.remote.PokemonsRemoteDataSource
import com.universodoandroid.pokemonjetpack.main.domain.entity.Pokemon
import com.universodoandroid.pokemonjetpack.main.domain.repository.PokemonsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class PokemonsRepositoryImpl(
    private val remoteDataSource: PokemonsRemoteDataSource
) : PokemonsRepository {

    override fun getPokemons(): Flow<List<Pokemon>> {
        return remoteDataSource.getPokemons().map {
            it.pokemons.map { response ->
                Pokemon(url = response.url, name = response.name)
            }
        }
    }
}