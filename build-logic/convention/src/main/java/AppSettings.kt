import org.gradle.api.JavaVersion

object AppSettings {
    const val APP_ID = "ru.mrz.template"
    const val APP_VERSION_NAME = "1.0.0" // X.Y.Z; X = Major, Y = minor, Z = Patch level
    const val APP_VERSION_CODE = 1
    val JAVA_VERSION = JavaVersion.VERSION_17 // Don't forgot to set in build gradle of project
    // and build src!
}
