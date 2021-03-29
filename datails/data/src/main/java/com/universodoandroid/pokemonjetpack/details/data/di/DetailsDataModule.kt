package com.universodoandroid.pokemonjetpack.details.data.di

import com.universodoandroid.pokemonjetpack.details.data.remote.DetailsRemoteDataSource
import com.universodoandroid.pokemonjetpack.details.data.remote.DetailsRemoteDataSourceImpl
import com.universodoandroid.pokemonjetpack.details.data.repository.DetailsRepositoryImpl
import com.universodoandroid.pokemonjetpack.details.data.repository.mapper.DetailsMapper
import com.universodoandroid.pokemonjetpack.details.domain.repository.DetailsRepository
import com.universodoandroid.pokemonjetpack.shared.common.koin.KoinModule
import org.koin.dsl.module

class DetailsDataModule : KoinModule {

    override val module = module {
        factory<DetailsRepository> {
            DetailsRepositoryImpl(
                detailsRemoteDataSource = get(),
                detailsMapper = DetailsMapper()
            )
        }
        factory<DetailsRemoteDataSource> {
            DetailsRemoteDataSourceImpl(
                ktorClient = get()
            )
        }
    }
}