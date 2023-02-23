package ru.mrz.feature.profile.di

import cafe.adriel.voyager.core.registry.screenModule
import org.koin.dsl.module
import ru.mrz.core.navigation.SharedScreen
import ru.mrz.feature.profile.pages.ProfileScreen

val profileKoinModule = module {  }

val profileScreenModule = screenModule {
    register<SharedScreen.Profile> {
        ProfileScreen()
    }
}
