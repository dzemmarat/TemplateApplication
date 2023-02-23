package ru.mrz.core.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed interface SharedScreen : ScreenProvider {
    object Home : SharedScreen
    object Add : SharedScreen
    object Profile : SharedScreen
}