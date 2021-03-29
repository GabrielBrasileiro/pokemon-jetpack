package com.universodoandroid.pokemonjetpack.details.data.remote.reponse

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AbilitiesResponse(
    @SerialName("ability") val ability: AbilityResponse
)