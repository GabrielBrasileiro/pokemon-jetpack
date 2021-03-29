package com.universodoandroid.pokemonjetpack.details.data.remote

import com.universodoandroid.pokemonjetpack.details.data.remote.reponse.DetailsResponse
import kotlinx.coroutines.flow.Flow

interface DetailsRemoteDataSource {

    fun getDetails(name: String): Flow<DetailsResponse>
}