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
    implementation("com.google.guava", "guava", "27.0.1-jre")

    /* compile(gradleApi())

    compile(kotlin("stdlib-jdk8"))


    compile("org.jetbrains.kotlin","kotlin-reflect", "1.3.50")

    testImplementation("org.assertj", "assertj-core", "3.12.2")
    testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.5.2")
    testRuntime("org.junit.jupiter","junit-jupiter-engine", "5.5.2") */
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
