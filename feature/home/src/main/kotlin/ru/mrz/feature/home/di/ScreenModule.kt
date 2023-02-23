package ru.mrz.feature.home.di

import cafe.adriel.voyager.core.registry.screenModule
import org.koin.dsl.module
import ru.mrz.core.navigation.SharedScreen
import ru.mrz.feature.home.pages.HomeScreen

val homeKoinModule = module { }

val homeScreenModule = screenModule {
    register<SharedScreen.Home> {
        HomeScreen()
    }
}
