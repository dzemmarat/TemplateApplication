@file:Suppress("unused")

package ru.mrz.core.common.extensions

/**
 * Return false when value is null
 */
fun Any?.notNull(): Boolean = this != null

/**
 * Return empty string when value is null.
 * When value don't equals to null return current in string format
 */
fun Any?.toStringOrEmpty(): String = this?.toString() ?: ""
