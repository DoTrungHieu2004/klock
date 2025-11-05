package com.hieu10.klock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hieu10.klock.ui.theme.KlockTheme
import com.hieu10.klock.ui.theme.klockTypography
import com.hieu10.klock.ui.theme.previews.ThemeShowcase

/**
 * Main Activity demonstrating our theme system
 *
 * EDUCATIONAL: We temporarily use ThemeShowcase to visually verify
 * our theme system works correctly before building the actual clock.
 * This is a common practice - build and test design systems first.
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KlockTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Temporary: Show theme showcase for testing
                    // Later: Replace with actual clock screen
                    ThemeShowcase()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KlockTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Klock Theming System Ready!",
                style = MaterialTheme.klockTypography.clockDisplay,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}