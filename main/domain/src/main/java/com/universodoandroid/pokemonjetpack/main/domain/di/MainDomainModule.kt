package com.universodoandroid.pokemonjetpack.main.domain.di

import com.universodoandroid.pokemonjetpack.main.domain.usecase.GetPokemonsUseCase
import com.universodoandroid.pokemonjetpack.main.domain.usecase.GetPokemonsUseCaseImpl
import com.universodoandroid.pokemonjetpack.shared.common.koin.KoinModule
import org.koin.dsl.module

class MainDomainModule : KoinModule {

    override val module = module {
        factory<GetPokemonsUseCase> { GetPokemonsUseCaseImpl(get()) }
    }
}