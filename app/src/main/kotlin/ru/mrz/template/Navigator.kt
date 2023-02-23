package ru.mrz.template

import cafe.adriel.voyager.core.registry.ScreenRegistry
import ru.mrz.feature.add.di.addScreenModule
import ru.mrz.feature.home.di.homeScreenModule
import ru.mrz.feature.profile.di.profileScreenModule

internal fun setupNavigator() {
    ScreenRegistry {
        addScreenModule()
        homeScreenModule()
        profileScreenModule()
    }
}