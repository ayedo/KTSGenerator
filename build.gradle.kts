import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    id("com.gradle.plugin-publish") version "1.2.2"
}

group = "ayedo"
version = "2.2.0"

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("com.github.ntrrgc", "ts-generator", "1.1.1")
    implementation("com.google.guava", "guava", "33.3.0-jre")

    // Testing
    val junitVersion = "5.8.2"
    testImplementation("org.junit.jupiter", "junit-jupiter-api", junitVersion)
    testImplementation("org.junit.jupiter","junit-jupiter-engine", junitVersion)
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }

    test {
        useJUnitPlatform()

        testLogging {
            events("passed", "skipped", "failed")
        }
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

gradlePlugin {
    website = "https://github.com/ayedo/ktsgenerator"
    vcsUrl = "https://github.com/ayedo/ktsgenerator.git"

    plugins {
        create("ktsgenerator") {
            id = "ch.ayedo.ktsgenerator"
            implementationClass = "ch.ayedo.ktsgenerator.TypeScriptGeneratorPlugin"
            displayName = "ktsgenerator"
            description = "Plugin to generate Typescript definitions from Kotlin classes."
            version = version
            tags = listOf("Kotlin", "Typescript", "Typescript-definitions", "Generator", "Typescript-generator")
        }
    }
}
