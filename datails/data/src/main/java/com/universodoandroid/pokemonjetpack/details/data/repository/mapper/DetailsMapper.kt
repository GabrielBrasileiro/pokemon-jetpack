package com.universodoandroid.pokemonjetpack.details.data.repository.mapper

import com.universodoandroid.pokemonjetpack.details.data.remote.reponse.DetailsResponse
import com.universodoandroid.pokemonjetpack.details.domain.entity.Ability
import com.universodoandroid.pokemonjetpack.details.domain.entity.Details
import com.universodoandroid.pokemonjetpack.details.domain.entity.Sprites

class DetailsMapper {

    operator fun invoke(response: DetailsResponse): Details {
        return response.run {
            Details(
                abilities = abilities.map {
                    Ability(it.ability.name, it.ability.url)
                },
                sprites = Sprites(
                    sprites.frontDefault,
                    sprites.backDefault
                )
            )
        }
    }
}