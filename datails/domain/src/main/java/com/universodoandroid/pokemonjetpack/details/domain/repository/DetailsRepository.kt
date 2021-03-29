package com.universodoandroid.pokemonjetpack.details.domain.repository

import com.universodoandroid.pokemonjetpack.details.domain.entity.Details
import kotlinx.coroutines.flow.Flow

interface DetailsRepository {
    fun getDetails(name: String): Flow<Details>
}