package com.universodoandroid.pokemonjetpack.main.presentation.flow.ext

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

open class FlowViewModel<S, E>(initialState: S, replay: Int = 0) : ViewModel() {

    protected val mutableState = MutableSharedFlow<S>()

    private val mutableEvent = MutableSharedFlow<E>(replay)

    fun getState(): SharedFlow<S> = mutableState

    fun getEvent(): SharedFlow<E> = mutableEvent

    fun sendEvent(event: E) {
        viewModelScope.launch {
            mutableEvent.emit(event)
        }
    }
}