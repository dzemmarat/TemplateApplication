@file:Suppress("unused")

package ru.mrz.core.common.extensions

import ru.mrz.core.common.BuildConfig
import java.util.Locale

inline fun isDebug(block: () -> Unit = {}): Boolean =
    isType(block, "debug")

inline fun isDev(block: () -> Unit = {}): Boolean =
    isFlavor(block,"dev")

inline fun isProd(block: () -> Unit = {}): Boolean =
    isFlavor(block,"prod")

inline fun isType(block: () -> Unit = {}, type: String): Boolean =
    BuildConfig.BUILD_TYPE.contains(type)
        .also { if (it) block() }

inline fun isFlavor(block: () -> Unit = {}, type: String): Boolean =
    BuildConfig.FLAVOR.lowercase(Locale.getDefault()).contains(type)
        .also { if (it) block() }
