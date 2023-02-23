import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask

buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
    }
    dependencies {
        classpath(libs.bundles.detekt)
    }
}

allprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")

    val projectSource = file(projectDir)
    val configFile = files("$rootDir/config/detekt/detekt.yml")
    val baselineFile = file("$rootDir/config/detekt/baseline.xml")
    val kotlinFiles = "**/*.kt"
    val resourceFiles = "**/resources/**"
    val buildFiles = "**/build/**"

    tasks.withType<Detekt>().configureEach {
        val autoFix = project.hasProperty("detektAutoFix")
        description = "Detekt build for all modules"
        parallel = true
//        ignoreFailures = true
        autoCorrect = autoFix
        buildUponDefaultConfig = true
        setSource(projectSource)
        baseline.set(baselineFile)
        config.setFrom(configFile)
        include(kotlinFiles)
        exclude(resourceFiles, buildFiles)
        reports {
            html.required.set(true) // observe findings in your browser with structure and code snippets
            xml.required.set(true) // checkstyle like format mainly for integrations like Jenkins
            txt.required.set(true) // similar to the console output, contains issue signature to
            // manually edit baseline files
            sarif.required.set(true) // standardized SARIF format (https://sarifweb.azurewebsites.net/)
            // to support integrations with Github Code Scanning
            md.required.set(true) // simple Markdown format
        }
    }

    tasks.withType<Detekt>().configureEach {
        jvmTarget = "17"
    }
    tasks.withType<DetektCreateBaselineTask>().configureEach {
        jvmTarget = "17"
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    id("com.android.library") version "7.3.0" apply false
    id("io.gitlab.arturbosch.detekt") version "1.22.0" apply false
}
