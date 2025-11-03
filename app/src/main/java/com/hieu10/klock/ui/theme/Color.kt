package com.hieu10.klock.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

/**
 * Klock Color System
 *
 * EDUCATIONAL NOTE: We define a comprehensive color system that supports both
 * light and dark themes. Notice how we use semantic naming (primary, secondary)
 * rather than literal names (blue, red). This makes theme switching consistent
 * and maintainable.
 */

// Light color scheme
private val LightColorPalette = lightColorScheme(
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
    onSurface = Color(0xFF1A1C1E)
)

// Dark color theme
private val DarkColorScheme = darkColorScheme(
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
    onSurface = Color(0xFFE2E2E6)
)

// Clock-specific colors that aren't in Material color scheme
val ClockHandHour = Color(0xFF2E5C8B)
val ClockHandMinute = Color(0xFFD84315)
val ClockHandSecond = Color(0xFFC62828)
val ClockFaceBackground = Color(0xFFFAFAFA)
val ClockMarkers = Color(0xFF424242)

// Theme selector
val KlockColorScheme = LightColorPalette