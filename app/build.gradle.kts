plugins {
    id("template.android.application")
    id("template.android.application.compose")
}

android {
    namespace = "ru.mrz.template"
    compileSdk = libs.versions.compile.sdk.version.get().toInt()

    defaultConfig {
        applicationId = AppSettings.APP_ID
        versionCode = AppSettings.APP_VERSION_CODE
        versionName = AppSettings.APP_VERSION_NAME
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        @Suppress("UNUSED_VARIABLE") val debug by getting {
            versionNameSuffix = ".debug"
        }
        @Suppress("UNUSED_VARIABLE") val release by getting {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            excludes.add("META-INF/DEPENDENCIES")
            excludes.add("META-INF/NOTICE")
            excludes.add("META-INF/LICENSE")
            excludes.add("META-INF/LICENSE.txt")
            excludes.add("META-INF/LICENSE-notice.md")
            excludes.add("META-INF/LICENSE.md")
        }
    }
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.navigation)
    implementation(projects.core.ui)
    implementation(projects.feature.home)
    implementation(projects.feature.add)
    implementation(projects.feature.profile)

    // AndroidX
    implementation(libs.bundles.androidx)
    implementation(libs.android.core.splash)

    // Accompanist
    implementation(libs.bundles.accompanist)

    // Koin
    implementation(libs.bundles.koin)

    // Orbit
    implementation(libs.bundles.orbit)

    // TEST
    testImplementation(libs.bundles.test)
    debugImplementation(libs.compose.debug.test.manifest)

    // Navigator
    implementation(libs.bundles.navigator)
}
