package ru.mrz.core.common.extensions

import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test
import kotlin.test.assertEquals

class AnyTest {
    @Test
    fun `should return false when value is null`() {
        val actual = null.notNull()
        assertFalse(actual)
    }

    @Test
    fun `should return true when value is not null`() {
        val value: Int? = 20
        val actual = value.notNull()
        assertTrue(actual)
    }

    @Test
    fun `should return string when value is not null`() {
        val value: String? = "str"
        val expected = "str"
        val actual = value.toStringOrEmpty()
        assertEquals(expected, actual)
    }

    @Test
    fun `should return empty string when value is null`() {
        val value: String? = null
        val expected = ""
        val actual = value.toStringOrEmpty()
        assertEquals(expected, actual)
    }
}