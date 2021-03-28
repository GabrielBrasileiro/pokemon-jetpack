package com.universodoandroid.pokemonjetpack.remote

import com.universodoandroid.pokemonjetpack.remote.interceptor.LogInterceptor
import com.universodoandroid.pokemonjetpack.remote.serializer.FormatterConfig
import com.universodoandroid.pokemonjetpack.remote.setup.DefaultRequest
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*

internal class KtorClientImpl(
    private val defaultRequest: DefaultRequest,
    private val log: LogInterceptor,
    private val formatterConfig: FormatterConfig
) : KtorClient {

    override fun getHttp(): HttpClient {
        return HttpClient(OkHttp) {
            engine {
                addInterceptor(log.getInterceptor())
                addNetworkInterceptor(log.getInterceptor())
            }
            defaultRequest {
                host = defaultRequest.getUrl()
                url {
                    protocol = defaultRequest.getProtocol()
                }
            }
            install(JsonFeature) {
                serializer = formatterConfig.getSerializer()
            }
        }
    }
}