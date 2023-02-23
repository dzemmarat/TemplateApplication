plugins {
    id("template.android.application")
    id("template.android.application.compose")
}

android {
    namespace = "ru.mrz.templateapplication"
    compileSdk = 33

    defaultConfig {
        applicationId = "ru.mrz.templateapplication"
        versionCode = 1
        versionName = "0.0.1" // X.Y.Z; X = Major, Y = minor, Z = Patch level

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

dependencies {}
