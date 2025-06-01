plugins {
    application
    //javafx
    id("org.openjfx.javafxplugin") version "0.1.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.openjfx:javafx-web:22:win")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "kelompok.agroflow.Main"
}

javafx {
    version = "21.0.7"
    modules = listOf("javafx.controls", "javafx.web")
}
