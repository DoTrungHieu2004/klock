package com.hieu10.klock.ui.theme.previews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hieu10.klock.ui.theme.ClockFaceBackground
import com.hieu10.klock.ui.theme.ClockFaceShapes
import com.hieu10.klock.ui.theme.ClockHandHour
import com.hieu10.klock.ui.theme.ClockHandMinute
import com.hieu10.klock.ui.theme.ClockHandSecond
import com.hieu10.klock.ui.theme.ClockMarkers
import com.hieu10.klock.ui.theme.KlockShape
import com.hieu10.klock.ui.theme.KlockTheme
import com.hieu10.klock.ui.theme.klockTypography

/**
 * Theme Preview System
 *
 * EDUCATIONAL NOTE: Previews are essential for rapid UI development and testing.
 * They allow us to see out theme system in action without running the full app.
 * We create multiple previews to test different aspects of our theme system.
 */

/**
 * Comprehensive theme showcase that demonstrates all our design tokens
 *
 * EDUCATIONAL: This shows how to create a design system documentation
 * within the app itself. Each section tests different aspects of our theme.
 */
@Composable
fun ThemeShowcase() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Color palette section
        Text(
            text = "🎨 Color system",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )
        ColorPaletteShowcase()

        // Typography scale section
        Text(
            text = "📝 Typography scale",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )
        TypographyScaleShowcase()

        // Clock-specific colors section
        Text(
            text = "⏰ Clock colors",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )
        ClockColorShowcase()

        // Shape system section
        Text(
            text = "🔷 Shape system",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )
        ShapeSystemShowcase()

        // Custom Klock typography
        Text(
            text = "🕰️ Klock typography",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )
        KlockTypographyShowcase()
    }
}

/**
 * Demonstrates the main color palette with semantic naming
 *
 * EDUCATIONAL: Shows how semantic color names work and their actual values.
 * This helps designers and developers understand the color system.
 */
@Composable
private fun ColorPaletteShowcase() {
    val colors = listOf(
        "Primary" to MaterialTheme.colorScheme.primary,
        "On primary" to MaterialTheme.colorScheme.onPrimary,
        "Primary container" to MaterialTheme.colorScheme.primaryContainer,
        "On primary container" to MaterialTheme.colorScheme.onPrimaryContainer,
        "Secondary" to MaterialTheme.colorScheme.secondary,
        "Background" to MaterialTheme.colorScheme.background,
        "Surface" to MaterialTheme.colorScheme.surface
    )

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        colors.forEach { (name, color) ->
            ColorSwatch(name = name, color = color)
        }
    }
}

/**
 * Demonstrates the typography scale with all text styles
 *
 * EDUCATIONAL: Shows the complete typographic hierarchy and how
 * different text styles relate to each other in the design system.
 */
@Composable
private fun TypographyScaleShowcase() {
    val textStyles = listOf(
        "displayLarge" to MaterialTheme.typography.displayLarge,
        "displayMedium" to MaterialTheme.typography.displayMedium,
        "headlineSmall" to MaterialTheme.typography.headlineSmall,
        "titleLarge" to MaterialTheme.typography.titleLarge,
        "titleMedium" to MaterialTheme.typography.titleMedium,
        "bodyLarge" to MaterialTheme.typography.bodyLarge,
        "bodyMedium" to MaterialTheme.typography.bodyMedium,
        "labelMedium" to MaterialTheme.typography.labelMedium
    )

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        textStyles.forEach { (name, style) ->
            Text(
                text = "$name - The quick brown fox jumps over the lazy dog",
                style = style
            )
        }
    }
}

/**
 * Shows clock-specific colors that extend our theme system
 *
 * EDUCATIONAL:Demonstrates how we extend the base Material theme
 * with app-specific color tokens for specialized components.
 */
@Composable
private fun ClockColorShowcase() {
    val clockColors = listOf(
        "Hour hand" to ClockHandHour,
        "Minute hand" to ClockHandMinute,
        "Second hand" to ClockHandSecond,
        "Clock face" to ClockFaceBackground,
        "Markers" to ClockMarkers
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        clockColors.forEach { (name, color) ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(color)
                )
                Text(
                    text = name,
                    style = MaterialTheme.typography.labelSmall,
                    maxLines = 2
                )
            }
        }
    }
}

/**
 * Demonstrates the shape system with different corner radii
 *
 * EDUCATIONAL: Shows how consistent shape scaling creates visual harmony
 * and how different shapes are used for different purposes.
 */
@Composable
private fun ShapeSystemShowcase() {
    val shapes = listOf(
        "Extra small" to KlockShape.extraSmall,
        "Small" to KlockShape.small,
        "Medium" to KlockShape.medium,
        "Large" to KlockShape.large,
        "Extra large" to KlockShape.extraLarge,
        "Clock face" to ClockFaceShapes
    )

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        shapes.forEach { (name, shape) ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(shape)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                )
                Text(
                    text = name,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

/**
 * Shows our custom Klock typography extensions
 *
 * EDUCATIONAL: Demonstrates how we extend the base typography system
 * with app-specific text styles for specialized use cases.
 */
@Composable
private fun KlockTypographyShowcase() {
    val klockTextStyles = listOf(
        "Clock display" to MaterialTheme.klockTypography.clockDisplay,
        "Clock label" to MaterialTheme.klockTypography.clockLabel,
        "Hand label" to MaterialTheme.klockTypography.handLabel
    )

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        klockTextStyles.forEach { (name, style) ->
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = "10:00:00 AM - Hanoi",
                    style = style
                )
            }
        }
    }
}

/**
 * Reusable color swatch component for color palette display
 *
 * EDUCATIONAL: Shows how to create reusable components for design system
 * documentation. This pattern can be used for any design token display.
 */
@Composable
private fun ColorSwatch(name: String, color: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(KlockShape.medium)
                .background(color)
        )
        Column {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = color.toHex(),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }
    }
}

/**
 * Extension function to convert color to hex string
 *
 * EDUCATIONAL: Demonstrates Kotlin extension functions for utility operations.
 * This makes our code more readable and follows Kotlin conventions.
 */
private fun Color.toHex(): String {
    val alpha = (alpha * 255).toInt()
    val red = (red * 255).toInt()
    val green = (green * 255).toInt()
    val blue = (blue * 255).toInt()
    return String.format("#%02X%02X%02X%02X", alpha, red, green, blue)
}

/**
 * Preview for light theme
 *
 * EDUCATIONAL: @Preview annotation allows Android Studio to render
 * composables in the design previews without running the app.
 * We can create multiple previews for different themes and configurations.
 */
@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
@Composable
fun ThemeShowcaseLightPreview() {
    KlockTheme {
        Surface {
            ThemeShowcase()
        }
    }
}

/**
 * Preview for dark theme
 *
 * EDUCATIONAL: We can simulate dark theme by using different background colors
 * and eventually by creating a proper dark color palette in our theme system.
 */
@Preview(
    name = "Dark Theme",
    showBackground = true,
    backgroundColor = 0xFF121212
)
@Composable
fun ThemeShowcaseDarkPreview() {
    // Note: In a real implementation, we'd switch to DarkColorPalette
    KlockTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            ThemeShowcase()
        }
    }
}

/**
 * Compact preview for quick theme testing
 *
 * EDUCATIONAL: Creating multiple preview sizes helps test responsive behavior
 * and ensures our theme works well on different screen sizes.
 */
@Preview(
    name = "Compact Theme",
    widthDp = 360,
    heightDp = 640
)
@Composable
fun ThemeShowcaseCompactPreview() {
    KlockTheme {
        Surface {
            ThemeShowcase()
        }
    }
}