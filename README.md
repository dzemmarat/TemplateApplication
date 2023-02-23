# Template application on kotlin

[![Use this template](https://img.shields.io/badge/from-TemplateApplication-brightgreen?logo=dropbox)](https://github.com/dzemmarat/TemplateApplication/generate) ![Language](https://img.shields.io/github/languages/top/dzemmarat/TemplateApplication?color=blue&logo=kotlin)

A simple android application template to setup your multimodule app with some extensions to work.

Template has static analysis for your code.

## How to use?

Click
on [![Use this template](https://img.shields.io/badge/-Use%20this%20template-brightgreen)](https://github.com/dzemmarat/TemplateApplication/generate)
and go!

Don't forget to update this places:

- [App ID](buildSrc/src/main/java/AppSettings.kt)
- [AndroidManifest](app/src/main/AndroidManifest.xml)
- Package of the source files

## Features

- **100% Kotlin-only template**.
- Some core modules for your easy work.
- Jetpack Compose setup ready to use.\
- Plugins for minimal setup in gradle of every module.
- 100% Gradle Kotlin DSL setup.
- Dependency versions managed via `buildSrc`.
- Kotlin Static Analysis via `detekt`.

## Gradle Setup

This template is using [**Gradle Kotlin DSL
**](https://docs.gradle.org/current/userguide/kotlin_dsl.html) as well as
the [Plugin DSL](https://docs.gradle.org/current/userguide/plugins.html#sec:plugins_block) to setup
the build.

Dependencies are centralized inside the Gradle Version Catalog in
the [libs.versions.toml](gradle/libs.versions.toml) file in the `gradle` folder.

## Static Analysis 🔍

This template is using [**detekt**](https://github.com/detekt/detekt) to analyze the source code,
with the configuration that is stored in the [detekt.yml](config/detekt/detekt.yml) file (the file
has been generated with the `detektGenerateConfig` task).
