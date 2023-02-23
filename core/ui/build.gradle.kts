plugins {
    id("template.android.library")
    id("template.android.library.compose")
}

android {
    namespace = "ru.mrz.core.ui"
}

dependencies {
    implementation(projects.core.common)

    implementation(libs.bundles.compose)
    implementation(libs.bundles.koin)

    testImplementation(libs.bundles.test)
}
