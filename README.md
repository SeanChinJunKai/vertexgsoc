# Vertex AI Kotlin Multiplatform Library

## What is it?

Kotlin Multiplatform SDK to access Google’s Gemini via Vertex AI on Android and iOS

This SDK provides a simple and idiomatic way to integrate Google’s Gemini (powered by Vertex AI) into your Android and iOS applications using Kotlin Multiplatform.


## Getting Started

### Requirements
- A Compose Multiplatform project with either an Android or iOS target
- Kotlin `2.1.10` or higher

### Getting the API_KEY

1. Follow the instructions at this link to set up your Google Cloud project: [Setup GCP](https://cloud.google.com/vertex-ai/generative-ai/docs/start/quickstarts/quickstart-multimodal#setup-gcp).
2. Follow the instructions at this link to set up your local environment: [Setup Local Environment](https://cloud.google.com/vertex-ai/generative-ai/docs/start/quickstarts/quickstart-multimodal#setup-local).
3. Run the following command in your CLI to generate an access token and make note of this key:
   ```
   gcloud auth print-access-token
   ```

Use the generated key in your application wherever the `API_KEY` is required.



### Add the library into your project

```kotlin
// composeApp/build.gradle.kts
kotlin {
    commonMain.dependencies {
        implementation(libs.vertexgsoc)
    }
}

// gradle/libs.versions.toml
[versions]
vertexgsoc = "1.0.0"

[libraries]
vertexgsoc = { group = "io.github.seanchinjunkai", name = "vertexgsoc", version.ref = "vertexgsoc" }
```

### Calling the model in your app
```kotlin
val model =  GenerativeModel(key = "API_KEY", model = "gemini-1.5-flash-002", RequestOptions(projectId = "gemini-kmp"))

val response: String? = result.response?.text 
```

## Try sample app

Try these apps built with this SDK by the community:

- [SeanChinJunKai/VertexSample](https://github.com/SeanChinJunKai/VertexSample): Kotlin Multiplatform sample that uses Gemini via Vertex AI. Runs on Android and iOS.

## Features of Gemini with Vertex AI supported by this SDK
| Feature                              | Currently Supported |
|--------------------------------------|---------------------|
| Generate text (text-only input)      | ✅                  |
| Generate text (multimodal input)     | ❌                  |
| Generate structured output (JSON)    | ❌                  |
| Generate images                      | ❌                  |
| Multi-turn chat                      | ❌                  |
| Function calling (tools)             | ❌                  |
| Count tokens and billable characters | ❌                  |

## Important Note: Not Suitable for Production Use

This library is currently in its initial development stages and is not intended for production use. The following reasons should be considered:

1. **Limited Features:** Not all features of Google’s Gemini via Vertex AI are supported, as outlined in the features table above.
2. **Lack of Production-Grade Stability:** The SDK has not been extensively tested for large-scale production environments, and the codebase may undergo significant changes in the future.
3. **Security Considerations:** As this library handles sensitive data such as API keys, proper security and compliance measures may not be fully implemented or sufficient for production systems.
4. **Performance Constraints:** The performance of this SDK in high-load or real-time production scenarios has not been benchmarked.

If you choose to use this library, it is highly recommended to do so for prototyping, experimentation, or non-critical applications only. For production-grade solutions, consider implementing or integrating rigorously tested alternatives or tools.

