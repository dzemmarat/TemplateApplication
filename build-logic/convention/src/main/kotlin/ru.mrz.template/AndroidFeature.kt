package ru.mrz.template

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal fun Project.configureFeature(
    commonExtension: CommonExtension<*, *, *, *>,
) {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    commonExtension.apply {
        dependencies {
            add("implementation", project(":core:ui"))
            add("implementation", project(":core:common"))
            add("implementation", project(":core:navigation"))

            // AndroidX
            add("implementation", libs.findBundle("androidx").get())

            // Accompanist
            add("implementation", libs.findBundle("accompanist").get())

            // Koin
            add("implementation", libs.findBundle("koin").get())

            // Orbit
            add("implementation", libs.findBundle("orbit").get())
            add("testImplementation", libs.findLibrary("orbit_test").get())

            // Navigator
            add("implementation", libs.findBundle("navigator").get())
        }
    }
}
