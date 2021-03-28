package com.universodoandroid.pokemonjetpack.remote.setup

import io.ktor.http.*

interface DefaultRequest {
    fun getUrl(): String
    fun getProtocol(): URLProtocol
}