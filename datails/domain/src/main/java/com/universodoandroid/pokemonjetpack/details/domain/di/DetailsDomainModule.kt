package com.universodoandroid.pokemonjetpack.details.domain.di

import com.universodoandroid.pokemonjetpack.details.domain.usecase.GetDetailsUseCase
import com.universodoandroid.pokemonjetpack.details.domain.usecase.GetDetailsUseCaseImpl
import com.universodoandroid.pokemonjetpack.shared.common.koin.KoinModule
import org.koin.dsl.module

class DetailsDomainModule : KoinModule {

    override val module = module {
        factory<GetDetailsUseCase> {
            GetDetailsUseCaseImpl(
                detailsRepository = get()
            )
        }
    }
}