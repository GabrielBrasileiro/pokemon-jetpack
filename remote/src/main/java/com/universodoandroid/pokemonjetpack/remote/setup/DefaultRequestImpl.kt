package com.universodoandroid.pokemonjetpack.remote.setup

import io.ktor.http.*

internal class DefaultRequestImpl : DefaultRequest {

    override fun getUrl(): String = "pokeapi.co/api/v2"

    override fun getProtocol(): URLProtocol = URLProtocol.HTTPS
}