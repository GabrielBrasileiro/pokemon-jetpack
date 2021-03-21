package com.universodoandroid.pokemonjetpack.remote.serializer

import io.ktor.client.features.json.serializer.*
import kotlinx.serialization.json.Json

internal class FormatterConfigImpl : FormatterConfig {

    override fun getSerializer(): KotlinxSerializer {
        return KotlinxSerializer(Json {
            ignoreUnknownKeys = true
            isLenient = true
            encodeDefaults = false
        })
    }
}