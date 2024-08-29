import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    // `java-gradle-plugin`
    // TODO: id("com.gradle.plugin-publish") version "0.10.0"
}

group = "ayedo"
version = "2.1.0"

repositories {
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
    }
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

dependencies {
    implementation("com.github.ntrrgc", "ts-generator", "1.1.1")
    implementation("com.google.guava", "guava", "33.3.0-jre")

    // Testing
    val junitVersion = "5.8.2"
    testImplementation("org.junit.jupiter", "junit-jupiter-api", junitVersion)
    testImplementation("org.junit.jupiter","junit-jupiter-engine", junitVersion)
}

/* tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
} */

gradlePlugin {
    plugins {
        create("ktsgenerator") {
            id = "ch.ayedo.ktsgenerator"
            displayName = "ktsgenerator"
            description = "Plugin to generate Typescript definitions from Kotlin classes."
            version = version
            implementationClass = "ch.ayedo.ktsgenerator.TypeScriptGeneratorPlugin"
        }
    }
}

/* TODO: pluginBundle {
    website = "https://github.com/ayedo/ktsgenerator"
    vcsUrl = "https://github.com/ayedo/ktsgenerator.git"
    tags = listOf("Kotlin", "Typescript", "Typescript-definitions", "Generator", "Typescript-generator")
} */
