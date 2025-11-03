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

/**
 * Klock Custom Theme System
 *
 * EDUCATIONAL NOTE: We're using MaterialTheme as our foundation but extending it
 * with custom properties specific to our clock app. This demonstrates how to
 * create a scalable theming system that can grow with your app's needs.
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

/**
 * Main theme composable that wraps MaterialTheme and provides our custom properties
 *
 * EDUCATIONAL: This demonstrates theme composition - building upon MaterialTheme
 * while adding our own custom properties. This pattern is used by many large apps
 * to maintain consistency while having app-specific design tokens.
 */
@Composable
fun KlockTheme(
    content: @Composable () -> Unit
) {
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

    MaterialTheme(
        colorScheme = KlockColorScheme,
        typography = MaterialTheme.typography,  // We'll override Material typography selectively
    ) {
        CompositionLocalProvider(
            LocalKlockTypography provides typography
        ) {
            content()
        }
    }
}

// Extension properties for easy access
val MaterialTheme.klockTypography: KlockTypography
    @Composable
    @ReadOnlyComposable
    get() = LocalKlockTypography.current