package com.universodoandroid.pokemonjetpack.main.data.remote

import com.universodoandroid.pokemonjetpack.main.data.remote.reponse.PokemonsResponse
import com.universodoandroid.pokemonjetpack.remote.KtorClient
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

private const val PATH = "pokemon"

internal class PokemonsRemoteDataSourceImpl(
    private val ktorClient: KtorClient
) : PokemonsRemoteDataSource {

    override fun getPokemons(): Flow<PokemonsResponse> {
        return flow {
            emit(ktorClient.getHttp().get<PokemonsResponse>(path = PATH) {
                method = HttpMethod.Get
            })
        }
    }
}