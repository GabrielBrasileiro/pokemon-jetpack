package com.universodoandroid.pokemonjetpack.details.domain.usecase

import com.universodoandroid.pokemonjetpack.details.domain.entity.Details
import kotlinx.coroutines.flow.Flow

interface GetDetailsUseCase {
    operator fun invoke(name: String): Flow<Details>
}