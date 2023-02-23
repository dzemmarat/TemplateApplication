package ru.mrz.template

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import ru.mrz.feature.add.di.addScreenModule
import ru.mrz.feature.home.di.homeScreenModule
import ru.mrz.feature.profile.di.profileScreenModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin(this)
        setupNavigator()
    }
}