package ch.ayedo.ktsgenerator

import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GradleApplyTest {

    @Test
    fun addPluginToProject() {
        ProjectBuilder.builder().build()
            .also { it.pluginManager.apply("ch.ayedo.ktsgenerator") }
            .task(hashMapOf("type" to TypeScriptGeneratorTask::class.java), "generateTypescriptDefinitions")
            .also { assertTrue(it is TypeScriptGeneratorTask) }
    }
}
