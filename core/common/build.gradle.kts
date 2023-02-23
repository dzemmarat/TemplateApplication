plugins {
    id("template.android.library")
}

android {
    namespace = "ru.mrz.core.common"
}

dependencies {
    testImplementation(libs.bundles.test)
}