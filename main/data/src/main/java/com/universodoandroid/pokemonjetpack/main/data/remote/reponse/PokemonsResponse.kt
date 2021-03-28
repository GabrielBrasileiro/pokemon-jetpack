package com.universodoandroid.pokemonjetpack.main.data.remote.reponse

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonsResponse(
    @SerialName("results")
    val pokemons: List<PokemonResponse>
)

@Serializable
data class PokemonResponse(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
)