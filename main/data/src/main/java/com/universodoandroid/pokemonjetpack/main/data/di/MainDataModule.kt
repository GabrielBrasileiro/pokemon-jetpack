package com.universodoandroid.pokemonjetpack.main.data.di

import com.universodoandroid.pokemonjetpack.main.data.repository.PokemonsRepositoryImpl
import com.universodoandroid.pokemonjetpack.main.domain.repository.PokemonsRepository
import com.universodoandroid.pokemonjetpack.shared.koin.KoinModule
import org.koin.dsl.module

class MainDataModule : KoinModule {

    override val module = module {
        factory<PokemonsRepository> { PokemonsRepositoryImpl() }
    }
}