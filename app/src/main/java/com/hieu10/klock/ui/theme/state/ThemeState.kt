package com.hieu10.klock.ui.theme.state

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * Theme State Management System
 *
 * EDUCATIONAL NOTE: We create a stable state holder for theme configuration.
 * This follows state hoisting principles and makes our theme system
 * testable and predictable. The state is simple and focused only on theme concerns.
 */

/**
 * Represents the available theme modes in the app
 *
 * EDUCATIONAL: Using sealed classes for theme modes ensures we handle
 * all possible cases and provides type safety. The system theme option
 * demonstrates respect for user system preferences.
 */
sealed class ThemeMode {
    object Light: ThemeMode()
    object Dark: ThemeMode()
    object System: ThemeMode()
}

/**
 * Stable state holder for theme configuration
 *
 * EDUCATIONAL: @Stable annotation tells Compose that this state holder
 * will notify changes appropriately. This helps Compose optimize recomposition.
 */
@Stable
class ThemeState(
    initialThemeMode: ThemeMode = ThemeMode.System
) {
    var themeMode by mutableStateOf(initialThemeMode)
        private set

    /**
     * Determines if dark theme should be used based on current mode
     *
     * EDUCATIONAL: In a real app, we'd check system dark mode setting here.
     * For now, we simulate it. This separation allows us to easily add
     * system theme detection later.
     */
    val isDarkTheme: Boolean
        get() = when (themeMode) {
            ThemeMode.Light -> false
            ThemeMode.Dark -> true
            ThemeMode.System -> false // Simulate system defaulting to light for now
        }

    fun updateThemeMode(mode: ThemeMode) {
        themeMode = mode
    }

    fun toggleTheme() {
        themeMode = when (themeMode) {
            ThemeMode.Light -> ThemeMode.Dark
            ThemeMode.Dark -> ThemeMode.Light
            ThemeMode.System -> ThemeMode.Light // Cycle to light when toggling from system
        }
    }

    /**
     * Gets descriptive name for current theme mode
     *
     * EDUCATIONAL: This demonstrates how to provide user-friendly
     * representations of internal state for UI display.
     */
    fun getThemeDisplayName(): String {
        return when (themeMode) {
            ThemeMode.Light -> "Light theme"
            ThemeMode.Dark -> "Dark theme"
            ThemeMode.System -> "System default"
        }
    }
}