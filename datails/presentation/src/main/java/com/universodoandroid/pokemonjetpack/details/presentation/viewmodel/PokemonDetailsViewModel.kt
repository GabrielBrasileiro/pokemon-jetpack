package com.universodoandroid.pokemonjetpack.details.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.universodoandroid.pokemonjetpack.details.domain.entity.Details
import com.universodoandroid.pokemonjetpack.details.domain.usecase.GetDetailsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import java.lang.Exception

internal class PokemonDetailsViewModel(
    private val name: String,
    private val getDetailsUseCase: GetDetailsUseCase
) : ViewModel() {

    private val mutableLiveData = MutableLiveData<Details>()

    fun getState(): LiveData<Details> = mutableLiveData

    init {
        loadDetails()
    }

    private fun loadDetails() {
        viewModelScope.launch {
            try {
                getDetailsUseCase.invoke(name)
                    .flowOn(Dispatchers.IO)
                    .collect {
                        mutableLiveData.value = it
                    }
            } catch (e: Exception) {
                print(e.message)
            }
        }
    }
}