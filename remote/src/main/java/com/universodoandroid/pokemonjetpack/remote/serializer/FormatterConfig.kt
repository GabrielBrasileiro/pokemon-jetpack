package com.universodoandroid.pokemonjetpack.remote.serializer

import io.ktor.client.features.json.serializer.*
import kotlinx.serialization.json.Json

internal interface FormatterConfig {
    fun getSerializer(): KotlinxSerializer
}