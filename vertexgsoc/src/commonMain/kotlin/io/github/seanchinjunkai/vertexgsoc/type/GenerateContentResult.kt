package io.github.seanchinjunkai.vertexgsoc.type

data class GenerateContentResult(
    val isSuccess: Boolean,
    val response: GenerateContentResponse? = null,
    val error: String? = null,
)