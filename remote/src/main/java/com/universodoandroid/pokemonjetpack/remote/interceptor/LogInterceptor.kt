package com.universodoandroid.pokemonjetpack.remote.interceptor

import okhttp3.logging.HttpLoggingInterceptor

internal interface LogInterceptor {
    fun getInterceptor(): HttpLoggingInterceptor
}