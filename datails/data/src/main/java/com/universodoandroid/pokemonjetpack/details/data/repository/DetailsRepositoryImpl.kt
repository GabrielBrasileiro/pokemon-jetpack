package com.universodoandroid.pokemonjetpack.details.data.repository

import com.universodoandroid.pokemonjetpack.details.data.remote.DetailsRemoteDataSource
import com.universodoandroid.pokemonjetpack.details.data.repository.mapper.DetailsMapper
import com.universodoandroid.pokemonjetpack.details.domain.entity.Details
import com.universodoandroid.pokemonjetpack.details.domain.repository.DetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class DetailsRepositoryImpl(
    private val detailsRemoteDataSource: DetailsRemoteDataSource,
    private val detailsMapper: DetailsMapper
) : DetailsRepository {

    override fun getDetails(name: String): Flow<Details> {
        return detailsRemoteDataSource.getDetails(name)
            .map(detailsMapper::invoke)
    }
}