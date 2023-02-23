@file:Suppress("unused")

package ru.mrz.core.common.extensions

import android.telephony.PhoneNumberUtils
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

/**
 * Length of the russian phone number. 11 by default.
 */
private const val NUMBER_LENGTH = 11

/**
 * Replacing char on selected [position] to [replacement] char
 *
 * @param position selected replacing position. Starts from 0
 * @param replacement selected replacing char
 * @throws [StringIndexOutOfBoundsException] when position is out of bounds
 */
fun String.replaceCharAt(
    position: Int,
    replacement: Char,
): String = buildString {
    append(this@replaceCharAt)
    setCharAt(position - 1, replacement)
}

/**
 * Will format string as russian number. Sample:
 * ```
 * +7 (999) 999 99 99
 * ```
 * @throws IllegalArgumentException when string is empty or length != [NUMBER_LENGTH]
 */
// TODO NON TESTABLE FUNCTION
fun String.formatAsPhone(): String {
    return if (isNotBlank() && length == NUMBER_LENGTH) {
        val formattedPart = PhoneNumberUtils.formatNumber(
            substring(4),
            "RU"
        ).replace("-", " ")
        "+7 (${substring(1, 4)}) $formattedPart"
    } else {
        error("Cant recognize phone number: $this")
    }
}

private const val ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"

/**
 * Used to parse date in ISO8601 string to any other, using SimpleDateFormat
 *
 * @param pattern pattern to format to
 * */
fun String.fromISO(pattern: String): String = runCatching {
    val parsedDate = SimpleDateFormat(ISO_FORMAT, Locale.getDefault()).parse(this)
    parsedDate?.let {
        SimpleDateFormat(pattern, Locale.getDefault()).format(parsedDate)
    } ?: ""
}.getOrDefault("")

fun String.formatDate(patternFrom: String, patternTo: String): String = runCatching {
    val parsedDate = SimpleDateFormat(patternFrom, Locale.getDefault()).parse(this)
    parsedDate?.let {
        SimpleDateFormat(patternTo, Locale.getDefault()).format(parsedDate)
    } ?: ""
}.getOrDefault("")

/**
 * Pattern of Email Address
 */
const val EMAIL_PATTERN = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,8}$"

/**
 * Is a String a valid email address
 */
fun String.isEmailValid(): Boolean {
    val pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE)
    val matcher = pattern.matcher(this)
    return matcher.matches()
}

/**
 * Should you ignore case of substring?
 */
private fun ignoreOpt(ignoreCase: Boolean) =
    if (ignoreCase) setOf(RegexOption.IGNORE_CASE) else emptySet()

/**
 * Find indexes or substring
 */
fun String.findIndexes(
    substring: String,
    ignoreCase: Boolean = true,
) = substring.toRegex(ignoreOpt(ignoreCase))
    .findAll(this)
    .map { it.range.first to it.range.last }
    .toList()
