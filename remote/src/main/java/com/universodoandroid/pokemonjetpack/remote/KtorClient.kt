package com.universodoandroid.pokemonjetpack.remote

import io.ktor.client.*

interface KtorClient {
    fun getHttp(): HttpClient
}