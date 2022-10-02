package com.example

fun main() {
    val foos = listOf(AFoo(1, 2, 3), BFoo(2, 2, 3), BFoo(2, 3, 3), BFoo(2, 3, 4))
    foos.sortedWith(compareByDescending<Foo> { it }.thenByDescending { it.id2 }.thenBy { it.id3 })
        .also { println(it) }
    // sortedWith(compareBy<Person> { it.age }.thenBy { it.name }.thenBy { it.address })

    val bars  = listOf(ABar(3, "a"), ABar(2, "b"), BBar(2), BBar(1))
    bars.sortedWith(compareBy<Bar> {it}.thenByDescending { it.id1 })
        .also { println(it) }
    println(bars.sortedBy { it.id1 })
}

sealed interface Foo:Comparable<Foo> {
    val id1: Int
    val id2: Int
    val id3: Int
}

data class AFoo(
    override val id1: Int,
    override val id2: Int,
    override val id3: Int
) : Foo {
    override fun compareTo(other: Foo): Int {
        return when (other) {
            is AFoo -> {0}
            is BFoo -> {-1}
        }
    }
}

data class BFoo(
    override val id1: Int,
    override val id2: Int,
    override val id3: Int,
) : Foo {
    override fun compareTo(other: Foo): Int {
        return when (other) {
            is BFoo -> {0}
            is AFoo -> {1}
        }
    }
}

sealed interface Bar:Comparable<Bar> {
    val id1: Int
}

data class ABar(
    override val id1: Int,
    val a: String
) : Bar {
    override fun compareTo(other: Bar): Int {
        return when (other) {
            is ABar -> {
                if (other.a == "a" && a == "a") 0
                else 1
            }
            is BBar -> {0}
        }
    }
}

data class BBar(
    override val id1: Int,
) : Bar {
    override fun compareTo(other: Bar): Int {
        return when (other) {
            is ABar -> {
                if (other.a == "a") 0
                else -1
            }
            is BBar -> {0}
        }
    }
}
