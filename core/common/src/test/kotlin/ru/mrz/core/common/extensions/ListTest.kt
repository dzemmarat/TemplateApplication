package ru.mrz.core.common.extensions

import org.junit.Test
import org.junit.jupiter.api.Assertions

internal class ListTest {
    @Test
    fun `should return list of lists`() {
        val list1 = listOf("1", "2", "3")
        val list2 = listOf("4", "5", "6")
        val list3 = listOf("7", "8", "9")

        val expected = listOf(
            listOf("1", "4", "7"),
            listOf("2", "5", "8"),
            listOf("3", "6", "9"),
        )

        val actual = zip(list1, list2, list3)
        Assertions.assertEquals(expected, actual)
    }
}