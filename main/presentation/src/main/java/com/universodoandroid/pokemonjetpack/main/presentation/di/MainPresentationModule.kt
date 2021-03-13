package com.universodoandroid.pokemonjetpack.main.presentation.di

import com.mvvmredux.core.livedata.SingleLiveEvent
import com.universodoandroid.pokemonjetpack.main.presentation.PokemonsViewModel
import com.universodoandroid.pokemonjetpack.main.presentation.navigation.MainNavigationImpl
import com.universodoandroid.pokemonjetpack.main.presentation.reducer.PokemonsReducer
import com.universodoandroid.pokemonjetpack.shared.koin.KoinModule
import com.universodoandroid.pokemonsjetpack.navigation.main.MainNavigation
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

class MainPresentationModule : KoinModule {

    override val module = module {
        factoryViewModels()
        factoryNavigation()
    }

    private fun Module.factoryViewModels() {
        viewModel {
            PokemonsViewModel(
                event = SingleLiveEvent(),
                reducer = PokemonsReducer(),
                getPokemonsUseCase = get(),
            )
        }
    }

    private fun Module.factoryNavigation() {
        factory<MainNavigation> { MainNavigationImpl() }
    }
}