package com.intellij.ide.starter.examples.steps

import com.intellij.driver.sdk.ui.components.UiComponent.Companion.waitFound
import com.intellij.driver.sdk.ui.components.common.IdeaFrameUI
import com.intellij.driver.sdk.ui.components.common.toolwindows.projectView

object ProjectSteps {

    fun IdeaFrameUI.createClassFromTemplate(
        templateName: String,
        className: String
    ) {

        projectView {

            projectViewTree
                .waitFound()
                .clickPath(
                    "Quantum-Starter-Kit",
                    "src",
                    "main",
                    "java",
                    "com.quantum",
                    fullMatch = false
                )
        }

        keyboard {

            hotKey(
                java.awt.event.KeyEvent.VK_ALT,
                java.awt.event.KeyEvent.VK_INSERT
            )

            Thread.sleep(1000)

            typeText(templateName)

            enter()
        }

        keyboard {

            typeText(className)

            enter()

            Thread.sleep(1000)

            escape()
        }
    }
}