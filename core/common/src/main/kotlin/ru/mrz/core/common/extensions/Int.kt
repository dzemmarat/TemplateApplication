@file:Suppress("unused")

package ru.mrz.core.common.extensions

import android.content.res.Resources

val Int.density: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

fun Int.floorMod(other: Int): Int = when (other) {
    0 -> this
    else -> this - floorDiv(other) * other
}
