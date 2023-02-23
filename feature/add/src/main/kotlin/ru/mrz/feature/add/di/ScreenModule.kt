package ru.mrz.feature.add.di

import cafe.adriel.voyager.core.registry.screenModule
import org.koin.dsl.module
import ru.mrz.core.navigation.SharedScreen
import ru.mrz.feature.add.pages.AddScreen

val addKoinModule = module {  }

val addScreenModule = screenModule {
    register<SharedScreen.Add> {
        AddScreen()
    }
}
