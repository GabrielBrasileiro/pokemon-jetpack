package com.universodoandroid.pokemonjetpack.details.presentation.di

import com.universodoandroid.pokemonjetpack.details.presentation.navigation.DetailsNavigationImpl
import com.universodoandroid.pokemonjetpack.details.presentation.viewmodel.PokemonDetailsViewModel
import com.universodoandroid.pokemonjetpack.shared.common.koin.KoinModule
import com.universodoandroid.pokemonsjetpack.navigation.main.DetailsNavigation
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

class DetailsModule : KoinModule {

    override val module = module {
        factoryViewModel()
        factoryNavigation()
    }

    private fun Module.factoryViewModel() {
        viewModel { (name: String) ->
            PokemonDetailsViewModel(
                name = name,
                getDetailsUseCase = get(),
            )
        }
    }

    private fun Module.factoryNavigation() {
        factory<DetailsNavigation> { DetailsNavigationImpl() }
    }
}