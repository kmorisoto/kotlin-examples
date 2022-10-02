package com.example

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SortTest {

    @Test
    fun sortedBy() {
        val actual = listOf(1, 3, 5, 2, 0, 9).sorted()
        val expected = listOf(0, 1, 2, 3, 5, 9)
        assertEquals(expected, actual)

    }

    @Test
    fun sortedByDescending() {
        val actual = listOf(1, 3, 5, 2, 0, 9).sortedByDescending { it }
        val expected = listOf(9, 5, 3, 2, 1, 0)
        assertEquals(expected, actual)
    }

    data class User(val name: String, val age: Int) : Comparable<User> {
        override fun compareTo(other: User): Int = age - other.age
    }

    private val users = listOf(User("Alice", 1), User("Steve", 2), User("Bob", 4))

    @Test
    fun userSortedBy() {
        users.sortedBy { it.name }.also { println(it) }
        users.sortedByDescending { it.name }.also { println(it) }
    }

    @Test
    fun userSorted() {
        users.sorted().also { println(it) }
        users.sortedBy { it }.also { println(it) }
        users.sortedDescending().also { println(it) }
    }


    @Test
    fun userSortedWith() {
        val users = listOf(User("Alice", 1), User("Steve", 2), User("Bob", 4), User("Grace", 1))
        users.sortedWith(compareBy<User> { it.age }.thenByDescending { it.name })
            .also { println(it) }
        users.sortedWith(compareByDescending<User> { it.age }.thenBy { it.name })
            .also { println(it) }

        users.sortedWith(compareBy(User::age, User::name))
            .also { println(it) }
        users.sortedWith(compareByDescending(User::age).thenByDescending{it.name})
            .also { println(it) }
        users.sortedWith(compareValuesBy())
    }
}
