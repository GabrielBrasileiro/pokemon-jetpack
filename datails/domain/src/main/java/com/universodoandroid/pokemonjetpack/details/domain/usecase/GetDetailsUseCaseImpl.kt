package com.universodoandroid.pokemonjetpack.details.domain.usecase

import com.universodoandroid.pokemonjetpack.details.domain.entity.Details
import com.universodoandroid.pokemonjetpack.details.domain.repository.DetailsRepository
import kotlinx.coroutines.flow.Flow

internal class GetDetailsUseCaseImpl(
    private val detailsRepository: DetailsRepository
) : GetDetailsUseCase {

    override fun invoke(name: String): Flow<Details> {
        return detailsRepository.getDetails(name)
    }
}