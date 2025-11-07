package com.hieu10.klock.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hieu10.klock.ui.theme.state.ThemeState

/**
 * Enhanced Klock Theme with Dark Theme Support
 *
 * EDUCATIONAL NOTE: Our theme system now dynamically switches between
 * light and dark color palettes based on the theme state.
 * This demonstrates reactive theming that responds to state changes.
 */

// Custom theme properties that extend MaterialTheme
data class KlockTypography(
    val clockDisplay: TextStyle,
    val clockLabel: TextStyle,
    val handLabel: TextStyle
)

// CompositionLocal for out custom theme properties
val LocalKlockTypography = staticCompositionLocalOf {
    KlockTypography(
        clockDisplay = TextStyle.Default,
        clockLabel = TextStyle.Default,
        handLabel = TextStyle.Default
    )
}

// CompositionLocal for theme state to make it available throughout the app
val LocalThemeState = staticCompositionLocalOf<ThemeState> {
    error("No ThemeState provided")
}

/**
 * Main theme composable that wraps MaterialTheme and provides our custom properties
 *
 * EDUCATIONAL: This demonstrates theme composition - building upon MaterialTheme
 * while adding our own custom properties. This pattern is used by many large apps
 * to maintain consistency while having app-specific design tokens.
 */
@Composable
fun KlockTheme(
    themeState: ThemeState = ThemeState(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (themeState.isDarkTheme) DarkColorPalette else LightColorPalette

    val typography = KlockTypography(
        clockDisplay = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 20.sp
        ),
        clockLabel = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            lineHeight = 16.sp
        ),
        handLabel = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
            lineHeight = 12.sp
        )
    )

    // Provide both MaterialTheme and outr custom theme state
    CompositionLocalProvider(
        LocalThemeState provides themeState
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = MaterialTheme.typography,
            shapes = KlockShape
        ) {
            CompositionLocalProvider(
                LocalKlockTypography provides typography
            ) {
                content()
            }
        }
    }
}

// Extension properties for easy access
val MaterialTheme.klockTypography: KlockTypography
    @Composable
    @ReadOnlyComposable
    get() = LocalKlockTypography.current

// Extension to access theme state from anywhere in the app
val MaterialTheme.themeState: ThemeState
    @Composable
    @ReadOnlyComposable
    get() = LocalThemeState.current