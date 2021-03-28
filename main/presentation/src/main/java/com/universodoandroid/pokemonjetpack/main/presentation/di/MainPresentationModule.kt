package com.universodoandroid.pokemonjetpack.main.presentation.di

import android.content.Context
import com.mvvmredux.core.livedata.SingleLiveEvent
import com.universodoandroid.pokemonjetpack.main.presentation.viewmodel.PokemonsViewModel
import com.universodoandroid.pokemonjetpack.main.presentation.navigation.MainNavigationImpl
import com.universodoandroid.pokemonjetpack.main.presentation.router.PokemonsRouter
import com.universodoandroid.pokemonjetpack.main.presentation.router.PokemonsRouterImpl
import com.universodoandroid.pokemonjetpack.main.presentation.viewmodel.reducer.PokemonsReducer
import com.universodoandroid.pokemonjetpack.shared.common.koin.KoinModule
import com.universodoandroid.pokemonsjetpack.navigation.main.MainNavigation
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

class MainPresentationModule : KoinModule {

    override val module = module {
        factoryViewModels()
        factoryNavigation()
        factoryRouter()
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

    private fun Module.factoryRouter() {
        factory<PokemonsRouter> { (context: Context) ->
            PokemonsRouterImpl(
                context = context,
                detailsNavigation = get()
            )
        }
    }
}