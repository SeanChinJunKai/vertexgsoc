package io.github.seanchinjunkai.vertexgsoc

import io.ktor.client.plugins.*
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

class RequestOptions(
    val timeout: Duration,
    private val location: String = "us-central1",
    private val apiVersion: String = "v1",
    private val projectId: String,
) {
    constructor(
        timeout: Long? = HttpTimeoutConfig.INFINITE_TIMEOUT_MS,
        location: String = "us-central1",
        apiVersion: String = "v1",
        projectId: String,
    ) : this(
        (timeout ?: HttpTimeoutConfig.INFINITE_TIMEOUT_MS).toDuration(DurationUnit.MILLISECONDS),
        location,
        apiVersion,
        projectId

    )

    val baseUrl: String
        get() = "https://${location}-aiplatform.googleapis.com/${apiVersion}/projects/${projectId}/locations/${location}/publishers/google/models"

}