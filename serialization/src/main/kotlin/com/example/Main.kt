package com.example

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun main(args: Array<String>) {
    // Serializing objects
    val data = Project("kotlinx.serialization", "Kotlin")
    val string = Json.encodeToString(data)
    println(string) // {"name":"kotlinx.serialization","language":"Kotlin"}
    // Deserializing back into objects
    val obj = Json.decodeFromString<Project>(string)
    println(obj) // Project(name=kotlinx.serialization, language=Kotlin)
}

@Serializable
data class Project(val name: String, val language: String)
