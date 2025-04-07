package io.github.seanchinjunkai.vertexgsoc

import io.github.seanchinjunkai.vertexgsoc.type.*
import io.github.oshai.kotlinlogging.KotlinLogging
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

internal val JSON = Json {
    ignoreUnknownKeys = true
    prettyPrint = false
    isLenient = true
}

private val logger = KotlinLogging.logger {}

class GenerativeModel(
    private val key: String,
    private val model: String,
    private val requestOptions: RequestOptions,
) {
    private val client =
        HttpClient(getHttpEngine()) {
            expectSuccess = true
            install(HttpTimeout) {
                requestTimeoutMillis = requestOptions.timeout.inWholeMilliseconds
                socketTimeoutMillis = 80_000
            }
            install(ContentNegotiation) { json(JSON) }
        }

    suspend fun generateContent(prompt: String): GenerateContentResult {
        try {
            val response = client
                .post("${requestOptions.baseUrl}/$model:generateContent") {
                    header(HttpHeaders.Authorization, "Bearer $key")

                    contentType(ContentType.Application.Json)

                    setBody(
                        GenerateContentRequest(
                            contents = Content(
                                role = "user",
                                parts = listOf(
                                    Part(text = prompt)

                                )
                            )
                        )
                    )
                }
                .body<GenerateContentResponse>()
            return GenerateContentResult(
                isSuccess = true,
                response = response
            )
        } catch (e: Exception) {
            logger.error(e) { "Failed to generate content." }
            return GenerateContentResult(
                isSuccess = false,
                error = e.message
            )
        }
    }
}