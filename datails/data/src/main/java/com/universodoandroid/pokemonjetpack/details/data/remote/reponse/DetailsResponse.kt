package com.universodoandroid.pokemonjetpack.details.data.remote.reponse

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailsResponse(
    @SerialName("abilities") val abilities: List<AbilitiesResponse>,
    @SerialName("sprites") val sprites: SpritesResponse
)
