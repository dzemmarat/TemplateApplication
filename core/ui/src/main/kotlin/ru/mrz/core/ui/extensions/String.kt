@file:Suppress("unused")

package ru.mrz.core.ui.extensions

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import ru.mrz.core.common.extensions.findIndexes

/**
 * Highlight substring
 * @param substring is text that be highlighted
 * @param style is style of highlighted text
 * @param annotation is optional, you can add annotation to string
 * @param tag is optional, you can add tag, default is URL
 */
fun String.highlightTextPart(
    substring: String,
    style: SpanStyle,
    annotation: String? = null,
    tag: String? = null,
) = buildAnnotatedString {
    append(substring)
    this@highlightTextPart.findIndexes(substring).forEach { (start, end) ->
        addStyle(
            style = style,
            start = start,
            end = end + 1
        )

        annotation?.let {
            addStringAnnotation(
                tag = tag ?: "URL",
                annotation = it,
                start = start,
                end = end + 1
            )
        }
    }
}