package com.intellij.ide.starter.examples

import com.intellij.driver.sdk.invokeAction
import com.intellij.driver.sdk.ui.components.UiComponent.Companion.waitFound
import com.intellij.driver.sdk.ui.components.common.codeEditor
import com.intellij.driver.sdk.ui.components.common.ideFrame
import com.intellij.driver.sdk.ui.components.common.toolwindows.projectView
import com.intellij.driver.sdk.ui.components.settings.settingsDialog
//import com.intellij.ide.fileTemplates.FileTemplateUtil.createTemplate
import com.intellij.ide.starter.driver.engine.runIdeWithDriver
import com.intellij.ide.starter.examples.steps.ProjectSteps
import com.intellij.ide.starter.examples.steps.ProjectSteps.createClassFromTemplate
import com.intellij.ide.starter.examples.steps.SettingSteps.createTemplate
import com.intellij.ide.starter.junit5.hyphenateWithClass
import com.intellij.ide.starter.models.IdeInfo
import com.intellij.ide.starter.models.TestCase
import com.intellij.ide.starter.project.GitHubProject
import com.intellij.ide.starter.runner.CurrentTestMethod
import com.intellij.ide.starter.runner.Starter
import com.intellij.ide.starter.sdk.JdkDownloaderFacade.jdk21
import com.intellij.tools.ide.starter.product.idea.ultimate.IdeaUltimate
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.time.Duration.Companion.minutes

class SettingsEditorTestWithDriver {

    @Test
    fun openSettingsAndSelectEditor() {

        val testContext = Starter
            .newContext(
                CurrentTestMethod.hyphenateWithClass(), TestCase(
                    IdeInfo.IdeaUltimate, GitHubProject.fromGithub(
                        branchName = "master",
                        repoRelativeUrl = "Perfecto-Quantum/Quantum-Starter-Kit.git",
                        commitHash = "1dc6128c115cb41fc442c088174e81f63406fad5"
                    )
                )
            )
            .setupSdk(jdk21.toSdk())
            .setLicense(System.getenv("LICENSE_KEY"))
            .prepareProjectCleanImport()

        testContext.runIdeWithDriver().useDriverAndCloseIde {

            ideFrame {

                waitForIndicators(5.minutes)

                // Open Settings using main menu
                invokeAction("ShowSettings")

                // Work with Settings dialog
                settingsDialog {

                    createTemplate(
                        templateName = "TestTemplate",
                        templateContent = "public class \${NAME} {"
                    )

                }
                waitForIndicators(1.minutes)

                createClassFromTemplate(
                    templateName = "TestTemplate",
                    className = "MyGeneratedClass")

                // Verify generated content
                codeEditor().apply {
                    waitFound()

                    assertTrue(
                        text.contains("public class MyGeneratedClass"),
                        "Generated class content is incorrect"
                    )
                }
            }
        }
    }
}


