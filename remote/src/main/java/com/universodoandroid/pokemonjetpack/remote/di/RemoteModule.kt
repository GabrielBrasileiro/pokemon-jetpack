package com.universodoandroid.pokemonjetpack.remote.di

import com.universodoandroid.pokemonjetpack.remote.KtorClient
import com.universodoandroid.pokemonjetpack.remote.KtorClientImpl
import com.universodoandroid.pokemonjetpack.remote.interceptor.LogInterceptorImpl
import com.universodoandroid.pokemonjetpack.remote.serializer.FormatterConfigImpl
import com.universodoandroid.pokemonjetpack.remote.setup.DefaultRequest
import com.universodoandroid.pokemonjetpack.remote.setup.DefaultRequestImpl
import com.universodoandroid.pokemonjetpack.shared.koin.KoinModule
import org.koin.dsl.module

class RemoteModule : KoinModule {

    override val module = module {
        factory<DefaultRequest> { DefaultRequestImpl() }
        single<KtorClient> {
            KtorClientImpl(
                defaultRequest = DefaultRequestImpl(),
                log = LogInterceptorImpl(),
                formatterConfig = FormatterConfigImpl()
            )
        }
    }
}