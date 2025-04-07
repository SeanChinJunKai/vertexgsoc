package io.github.seanchinjunkai.vertexgsoc

import io.ktor.client.engine.*
import io.ktor.client.engine.darwin.*

actual fun getHttpEngine(): HttpClientEngine {
    return Darwin.create()
}