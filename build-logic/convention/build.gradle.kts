plugins {
    `kotlin-dsl`
}

group = "ru.profsoft.samberi.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.gradle.build)
    compileOnly(libs.kotlin.gradle.build)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "template.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "template.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "template.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidFeature") {
            id = "template.android.feature"
            implementationClass = "AndroidComposeFeatureConventionPlugin"
        }
        register("androidLibrary") {
            id = "template.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
    }
}
