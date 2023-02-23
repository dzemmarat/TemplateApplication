package ru.mrz.core.common.extensions

import org.junit.Test
import ru.mrz.core.common.extensions.separateNumber
import ru.mrz.core.common.extensions.splitToUnits
import kotlin.test.assertEquals

internal class DoubleTest {
    @Test
    fun `should return 1 303,03`() {
        val expected = listOf("1 303", "03")
        val currentNumber = 1_303.03
        val actual = currentNumber.splitToUnits()
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1 000,00`() {
        val expected = listOf("1 000", "00")
        val currentNumber = 1_000.00
        val actual = currentNumber.splitToUnits()
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 0,00`() {
        val expected = listOf("0", "00")
        val currentNumber = 0.0
        val actual = currentNumber.splitToUnits()
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1 000 000,00`() {
        val expected = listOf("1 000 000", "00")
        val currentNumber = 1_000_000.0
        val actual = currentNumber.splitToUnits()
        assertEquals(expected, actual)
    }

    @Test
    fun `should return -1 000,00`() {
        val expected = listOf("-1 000", "00")
        val currentNumber = -1000.0
        val actual = currentNumber.splitToUnits()
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 5,0`() {
        val expected = listOf("5", "0")
        val actual = 5.0.splitToUnits(1)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 5,000`() {
        val expected = listOf("5", "000")
        val actual = 5.0.splitToUnits(3)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 5 `() {
        val expected = listOf("5")
        val actual = 5.0.splitToUnits(0)
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1 000`() {
        val expected = "1 000"
        val actual = 1_000.separateNumber()
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 1,000`() {
        val expected = "1,000"
        val actual = 1_000.separateNumber(separator = ",")
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 5`() {
        val expected = "5"
        val actual = 5.separateNumber(separator = ",")
        assertEquals(expected, actual)
    }

    @Test
    fun `should return 0`() {
        val expected = "0"
        val actual = 0.separateNumber(separator = ",")
        assertEquals(expected, actual)
    }

    @Test
    fun `should return -100 000`() {
        val expected = "-100 000"
        val actual = (-100_000).separateNumber()
        assertEquals(expected, actual)
    }
}