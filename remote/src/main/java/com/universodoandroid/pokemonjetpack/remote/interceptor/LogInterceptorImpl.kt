package com.universodoandroid.pokemonjetpack.remote.interceptor

import okhttp3.logging.HttpLoggingInterceptor

internal class LogInterceptorImpl : LogInterceptor {

    override fun getInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}