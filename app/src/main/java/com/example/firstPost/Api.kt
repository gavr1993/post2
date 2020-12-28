package com.example.firstPost

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.http.*

object Api {
    const val url = "https://raw.githubusercontent.com/gavr1993/gson/master/posts.json"

    val client = HttpClient {
        install(JsonFeature) {
            acceptContentTypes = listOf(
                ContentType.Text.Plain,
                ContentType.Application.Json
            )
            serializer = GsonSerializer()
        }
    }
}