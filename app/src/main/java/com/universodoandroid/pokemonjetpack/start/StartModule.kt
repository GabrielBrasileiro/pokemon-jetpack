package com.universodoandroid.pokemonjetpack.start

import com.universodoandroid.pokemonjetpack.shared.common.koin.KoinModule
import org.koin.dsl.module

class StartModule : KoinModule {

    override val module = module {
        factory {
            StartRouter(mainNavigation = get())
        }
    }
}