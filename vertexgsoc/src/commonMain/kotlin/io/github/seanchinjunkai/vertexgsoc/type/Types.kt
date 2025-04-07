package io.github.seanchinjunkai.vertexgsoc.type

import kotlinx.serialization.Serializable

@Serializable
data class Content(
    val role: String,
    val parts: List<Part>
)

@Serializable
data class Part(
    val text: String
)

@Serializable
data class Candidate(
    val content: Content
)

@Serializable
data class GenerateContentResponse(
    val candidates: List<Candidate>
) {
    val text: String?
        get() = candidates.firstOrNull()?.content?.parts?.firstOrNull()?.text
}

@Serializable
data class GenerateContentRequest(
    val contents: Content
)
