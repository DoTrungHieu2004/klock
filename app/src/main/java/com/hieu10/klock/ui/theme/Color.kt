package com.hieu10.klock.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

/**
 * Klock Color System with Dark Theme Support
 *
 * EDUCATIONAL NOTE: Proper dark theme isn't just inverting colors.
 * We use Material Design 3's semantic color system that provides
 * appropriate colors for both light and dark environments.
 * This ensures accessibility and visual comfort in all conditions.
 */

// Light color scheme
val LightColorPalette = lightColorScheme(
    primary = Color(0xFF2E5C88),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFD4E3F7),
    onPrimaryContainer = Color(0xFF001C37),

    secondary = Color(0xFF545F71),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFD8E3F8),
    onSecondaryContainer = Color(0xFF111C2B),

    tertiary = Color(0xFF6D5676),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFF6D9FF),
    onTertiaryContainer = Color(0xFF261431),

    background = Color(0xFFFDFCFF),
    onBackground = Color(0xFF1A1C1E),

    surface = Color(0xFFFDFCFF),
    onSurface = Color(0xFF1A1C1E),
    surfaceVariant = Color(0xFFDFE2EB),
    onSurfaceVariant = Color(0xFF43474E),

    outline = Color(0xFF73777F),
    outlineVariant = Color(0xFFC3C6CF)
)

// Dark color theme
val DarkColorPalette = darkColorScheme(
    primary = Color(0xFFA6C8FF),
    onPrimary = Color(0xFF00315F),
    primaryContainer = Color(0xFF004786),
    onPrimaryContainer = Color(0xFFD4E3F7),

    secondary = Color(0xFFBCC7DB),
    onSecondary = Color(0xFF263141),
    secondaryContainer = Color(0xFF3C4758),
    onSecondaryContainer = Color(0xFFD8E3F8),

    tertiary = Color(0xFFD9BDE3),
    onTertiary = Color(0xFF3C2947),
    tertiaryContainer = Color(0xFF543F5E),
    onTertiaryContainer = Color(0xFFF6D9FF),

    background = Color(0xFF1A1C1E),
    onBackground = Color(0xFFE2E2E6),

    surface = Color(0xFF1A1C1E),
    onSurface = Color(0xFFE2E2E6),
    surfaceVariant = Color(0xFF43474E),
    onSurfaceVariant = Color(0xFFC3C6CF),

    outline = Color(0xFF8D9199),
    outlineVariant = Color(0xFF43474E)
)

// Clock-specific colors that adapt to theme
val LightClockHandHour = Color(0xFF2E5C8B)
val LightClockHandMinute = Color(0xFFD84315)
val LightClockHandSecond = Color(0xFFC62828)
val LightClockFaceBackground = Color(0xFFFAFAFA)
val LightClockMarkers = Color(0xFF424242)
val LightClockText = Color(0xFF1A1C1E)

val DarkClockHandHour = Color(0xFFA6C8FF)
val DarkClockHandMinute = Color(0xFFFF8A65)
val DarkClockHandSecond = Color(0xFFEF5350)
val DarkClockFaceBackground = Color(0xFF2D2D2D)
val DarkClockMarkers = Color(0xFFE0E0E0)
val DarkClockText = Color(0xFFE2E2E6)

/**
 * Theme-aware clock colors
 *
 * EDUCATIONAL: Instead of hardcoding colors, we provide functions
 * that return appropriate colors based on the current theme.
 * This makes our components automatically adapt to theme changes.
 */
data class ClockColors(
    val handHour: Color,
    val handMinute: Color,
    val handSecond: Color,
    val faceBackground: Color,
    val markers: Color,
    val text: Color
)

fun clockColors(isDarkTheme: Boolean): ClockColors {
    return if (isDarkTheme) {
        ClockColors(
            handHour = DarkClockHandHour,
            handMinute = DarkClockHandMinute,
            handSecond = DarkClockHandSecond,
            faceBackground = DarkClockFaceBackground,
            markers = DarkClockMarkers,
            text = DarkClockText
        )
    } else {
        ClockColors(
            handHour = LightClockHandHour,
            handMinute = LightClockHandMinute,
            handSecond = LightClockHandSecond,
            faceBackground = LightClockFaceBackground,
            markers = LightClockMarkers,
            text = LightClockText
        )
    }
}