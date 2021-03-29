package com.universodoandroid.pokemonjetpack.details.data.remote.reponse

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SpritesResponse(
    @SerialName("front_default") val frontDefault: String,
    @SerialName("back_default") val backDefault: String
)
