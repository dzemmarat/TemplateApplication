plugins {
    id("template.android.library")
}

android {
    namespace = "ru.mrz.core.navigation"
}

dependencies {
    // Koin
    implementation(libs.bundles.koin)

    // Navigator
    implementation(libs.bundles.navigator)
}