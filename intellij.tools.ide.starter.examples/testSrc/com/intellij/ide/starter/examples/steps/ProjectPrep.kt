package com.intellij.ide.starter.examples.steps

import com.intellij.ide.starter.junit5.hyphenateWithClass
import com.intellij.ide.starter.models.IdeInfo
import com.intellij.ide.starter.models.TestCase
import com.intellij.ide.starter.project.GitHubProject
import com.intellij.ide.starter.runner.CurrentTestMethod
import com.intellij.ide.starter.runner.Starter
import com.intellij.ide.starter.sdk.JdkDownloaderFacade.jdk21
import com.intellij.tools.ide.starter.product.idea.ultimate.IdeaUltimate

object ProjectPrep {

    fun createTestContext() =
        Starter
            .newContext(
                CurrentTestMethod.hyphenateWithClass(),
                TestCase(
                    IdeInfo.IdeaUltimate,
                    GitHubProject.fromGithub(
                        branchName = "master",
                        repoRelativeUrl = "Perfecto-Quantum/Quantum-Starter-Kit.git",
                        commitHash = "1dc6128c115cb41fc442c088174e81f63406fad5"
                    )
                )
            )
            .setupSdk(jdk21.toSdk())
            .setLicense(System.getenv("LICENSE_KEY"))
            .prepareProjectCleanImport()
}