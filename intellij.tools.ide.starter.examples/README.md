# IntelliJ IDEA UI Automation Tests with IDE Starter + Driver

This project contains automated UI tests for IntelliJ IDEA using:

- IntelliJ IDE Starter
- IntelliJ Driver Framework
- Kotlin
- JUnit 5

The tests automate real IDE workflows related to **File and Code Templates**.

---

# Implemented Test Scenarios

## 1. Create Custom Template and Generate Class

Test flow:
- Open IDE settings
- Navigate to `Editor -> File and Code Templates`
- Create a custom template
- Generate a new Java class from the created template
- Verify generated class content

---

## 2. Modify Existing Java Class Template

Test flow:
- Open default Java `Class` template
- Add a custom generated comment
- Create a new Java class
- Verify modified template content is present

---

## 3. Delete Custom Template

Test flow:
- Create a custom template
- Delete the template
- Verify it is no longer available in the `New` menu

---

# Project Structure

```text
steps/
├── ProjectPrep.kt
├── ProjectSteps.kt
└── SettingsSteps.kt

SettingsEditorTestWithDriver.kt
```

## Responsibilities

### `ProjectPrep.kt`
Responsible for:
- IDE context creation
- project setup
- SDK setup
- license configuration

### `ProjectSteps.kt`
Contains reusable IDE/project actions:
- create class from template
- project navigation

### `SettingsSteps.kt`
Contains reusable settings actions:
- create template
- modify template
- delete template

### `SettingsEditorTestWithDriver.kt`
Contains test scenarios and assertions.

---

# Technologies

- Kotlin
- JUnit5
- IntelliJ IDE Starter
- IntelliJ Driver SDK

---

# Running Tests

Run the test suite:

```bash
./gradlew test --tests "com.intellij.ide.starter.examples.SettingsEditorTestWithDriver"
```

---

# Notes

- Selectors were inspected using the IntelliJ Internal UI Inspector.
- Some interactions use keyboard navigation because certain Swing components are difficult to access reliably through selectors alone.
- Tests were implemented following JetBrains documentation and examples from:
    - IntelliJ IDE Starter
    - IntelliJ Driver SDK
    - JetBrains Plugin Testing blog posts

---

# References

- IntelliJ IDE Starter
- IntelliJ Driver SDK
- Internal UI Inspector
- JetBrains Plugin Testing Articles