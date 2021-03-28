package com.universodoandroid.pokemonjetpack.main.presentation.router

import android.content.Context
import com.universodoandroid.pokemonsjetpack.navigation.main.DetailsNavigation

internal class PokemonsRouterImpl(
    private val context: Context,
    private val detailsNavigation: DetailsNavigation
) : PokemonsRouter {

    override fun startDetails(name: String) {
        val intent = detailsNavigation.getIntent(context, name)
        context.startActivity(intent)
    }
}