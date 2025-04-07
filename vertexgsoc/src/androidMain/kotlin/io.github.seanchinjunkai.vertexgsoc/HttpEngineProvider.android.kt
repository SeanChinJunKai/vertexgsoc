package io.github.seanchinjunkai.vertexgsoc

import io.ktor.client.engine.*
import io.ktor.client.engine.okhttp.*

actual fun getHttpEngine(): HttpClientEngine {
    return OkHttp.create()
}