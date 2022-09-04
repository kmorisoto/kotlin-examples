package com.example

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun main() {
    val data = setOf(Project("foo", "ja"), Project("bar", "en"))
    val string = Json.encodeToString(data)
    println(string)
    val obj = Json.decodeFromString<List<Project>>(string)
    println(obj)
}
