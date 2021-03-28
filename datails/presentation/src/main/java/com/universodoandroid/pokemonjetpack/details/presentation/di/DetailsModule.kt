package com.universodoandroid.pokemonjetpack.details.presentation.di

import com.universodoandroid.pokemonjetpack.details.presentation.navigation.DetailsNavigationImpl
import com.universodoandroid.pokemonjetpack.shared.common.koin.KoinModule
import com.universodoandroid.pokemonsjetpack.navigation.main.DetailsNavigation
import org.koin.dsl.module

class DetailsModule : KoinModule {

    override val module = module {
        factory<DetailsNavigation> { DetailsNavigationImpl() }
    }
}