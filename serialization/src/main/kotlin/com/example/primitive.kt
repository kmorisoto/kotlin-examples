package com.example

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Serializable
data class Primitive(
    val byte: Byte,
    val short: Short,
    val int: Int,
    val long: Long,
    val float: Float,
    val double: Double,
    val boolean: Boolean,
    val char: Char,
    val string: String
)

fun main() {
    val data = Primitive(
        Byte.MAX_VALUE,
        Short.MAX_VALUE,
        Int.MAX_VALUE,
        Long.MAX_VALUE,
        Float.MAX_VALUE,
        Double.MAX_VALUE,
        boolean = true,
        char = '\"',
        string = "あいうえお"
    )
    val string = Json.encodeToString(data)
    println(string)
    val obj = Json.decodeFromString<Primitive>(string)
    println(obj)
}
