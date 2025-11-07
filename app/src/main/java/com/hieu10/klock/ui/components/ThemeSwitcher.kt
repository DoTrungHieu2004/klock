package com.hieu10.klock.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.hieu10.klock.R
import com.hieu10.klock.ui.theme.state.ThemeMode
import com.hieu10.klock.ui.theme.themeState

/**
 * Theme Switching Components
 *
 * EDUCATIONAL NOTE: These components demonstrate how to create
 * accessible, theme-aware UI controls. They use Material Design 3
 * components and follow accessibility best practices.
 */

/**
 * Simple theme toggle button that cycles through themes
 *
 * EDUCATIONAL: This shows a minimal theme switcher that's perfect
 * for app bars or quick settings. It demonstrates state mutation
 * through the provided theme s
 */
@Composable
fun ThemeToggleButton(
    modifier: Modifier = Modifier
) {
    val themeState = MaterialTheme.themeState

    val (icon, contentDescription) = when (themeState.themeMode) {
        ThemeMode.Light -> R.drawable.icon_dark_mode to "Switch to dark theme"
        ThemeMode.Dark -> R.drawable.icon_light_mode to "Switch to light theme"
        ThemeMode.System -> R.drawable.icon_setings to "Switch to system theme"
    }

    Icon(
        painter = painterResource(id = icon),
        contentDescription = contentDescription,
        modifier = modifier
            .clickable { themeState.toggleTheme() }
            .padding(8.dp),
        tint = MaterialTheme.colorScheme.onSurface
    )
}

/**
 * Comprehensive theme selector with all options
 *
 * EDUCATIONAL: This demonstrates how to create an accessible
 * selection interface with proper semantics and visual feedback
 */
@Composable
fun ThemeSelector(
    modifier: Modifier = Modifier
) {
    val themeState = MaterialTheme.themeState

    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        tonalElevation = 2.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .selectableGroup(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Theme settings",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            // Theme options
            listOf(
                ThemeMode.Light to "Light theme",
                ThemeMode.Dark to "Dark theme",
                ThemeMode.System to "System default"
            ).forEach { (mode, label) ->
                ThemeOption(
                    label = label,
                    selected = themeState.themeMode == mode,
                    onSelected = { themeState.updateThemeMode(mode) }
                )
            }
        }
    }
}

@Composable
private fun ThemeOption(
    label: String,
    selected: Boolean,
    onSelected: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .selectable(
                selected = selected,
                onClick = onSelected,
                role = Role.RadioButton
            )
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        RadioButton(
            selected = selected,
            onClick = null  // null because we handle click in the row
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.weight(1f)
        )
    }
}