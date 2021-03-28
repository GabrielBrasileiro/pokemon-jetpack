package com.universodoandroid.pokemonjetpack.shared.common.koin

import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module

interface KoinModule {
    val module: Module
}

fun KoinModule.load() {
    loadKoinModules(module)
}