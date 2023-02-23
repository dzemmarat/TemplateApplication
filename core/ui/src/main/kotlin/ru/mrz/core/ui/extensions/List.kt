@file:Suppress("unused")

package ru.mrz.core.ui.extensions

import androidx.compose.runtime.Composable

@Composable
fun <T> List<T>.ifNotLast(index: Int, block: @Composable () -> Unit) =
    if (index < this.lastIndex) block.invoke() else Unit