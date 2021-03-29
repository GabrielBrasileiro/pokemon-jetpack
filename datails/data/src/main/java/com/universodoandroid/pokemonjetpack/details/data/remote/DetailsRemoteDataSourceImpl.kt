package com.universodoandroid.pokemonjetpack.details.data.remote

import com.universodoandroid.pokemonjetpack.details.data.remote.reponse.DetailsResponse
import com.universodoandroid.pokemonjetpack.remote.KtorClient
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class DetailsRemoteDataSourceImpl(
    private val ktorClient: KtorClient
) : DetailsRemoteDataSource {

    override fun getDetails(name: String): Flow<DetailsResponse> {
        return flow {
            val path = "pokemon/$name"

            emit(ktorClient.getHttp().get<DetailsResponse>(path) {
                method = HttpMethod.Get
            })
        }
    }
}