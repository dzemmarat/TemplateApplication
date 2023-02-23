package ru.mrz.core.common.extensions

import kotlin.math.absoluteValue

/** Split number to hundreds, thousands etc.
 * @param [numbersAfterSign] how many numbers will be displayed after the sign. Default value 2
 * */
fun Double.splitToUnits(
    numbersAfterSign: Int = 2,
): List<String> =
    "%.${numbersAfterSign}f"
        .format(this)
        .split(",")
        .mapIndexed { index, s ->
            runCatching {
                if (index == 0) s.toInt().separateNumber()
                else s
            }.getOrDefault(s)
        }

/**
 * Define number with space separator
 * ``` kotlin
 * println(1000.separateLargeNumber())
 * ```
 * @throws IllegalArgumentException if parameter not [Int] or [String]
 */
fun Int.separateNumber(
    separator: String = " ",
) = buildString {
    absoluteValue.toString()
        .reversed()
        .forEachIndexed { index, char ->
            if (index % 3 == 0 && index != 0) append(separator)
            append(char)
        }

    if (this@separateNumber < 0) append('-')
    reverse()
}.trim()
