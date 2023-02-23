package ru.mrz.core.common.extensions

import org.junit.Test
import org.junit.jupiter.api.Assertions
import kotlin.test.assertEquals

class StringTest {
    @Test
    fun `should change char at position 3`() {
        val expect = "1254"
        val actual = "1234".replaceCharAt(3, '5')
        assertEquals(expect, actual)
    }

    @Test
    fun `should throw exception when char at unreachable position`() {
        Assertions.assertThrows(StringIndexOutOfBoundsException::class.java) {
            "1234".replaceCharAt(200, '5')
        }
    }

    @Test
    fun `find indexes of substring`() {
        val expect = listOf(0 to 4)
        val actual = "Hello, World".findIndexes("Hello")
        assertEquals(expect, actual)
    }
}