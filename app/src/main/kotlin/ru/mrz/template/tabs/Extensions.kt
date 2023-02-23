package ru.mrz.template.tabs

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import ru.mrz.core.navigation.SharedScreen

@Composable
fun SharedScreen.resolve() {
    val screen = rememberScreen(provider = this)
    Navigator(screen) { navigator ->
        navigator.lastItem.Content()
    }
}