plugins {
    id("template.android.library")
    id("template.android.feature")
    id("template.android.library.compose")
}

android {
    namespace = "ru.mrz.feature.profile"
}

dependencies {
    implementation(projects.core.navigation)
}