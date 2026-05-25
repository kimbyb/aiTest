package com.intellij.ide.starter.examples.steps

import com.intellij.driver.sdk.ui.components.settings.SettingsDialogUiComponent

object SettingSteps {

    fun SettingsDialogUiComponent.createTemplate(
        templateName: String,
        templateContent: String
    ) {
        openTreeSettingsSection("Editor")

        x("//div[@text='File and Code Templates']").click()

        x("//div[@accessiblename='Create Template']").click()

        x("//div[@accessiblename='Name:' and @class='javax.swing.JTextField']")

        keyboard {
            typeText("TestTemplate")
        }

        x("//div[@accessiblename='Editor']").click()

        keyboard {

            hotKey(
                java.awt.event.KeyEvent.VK_CONTROL,
                java.awt.event.KeyEvent.VK_A
            )

            backspace()

            typeText("public class \${NAME} {")

            enter()
        }

        x("//div[@accessiblename='Apply']").click()
        x("//div[@accessiblename='OK']").click()

    }
}