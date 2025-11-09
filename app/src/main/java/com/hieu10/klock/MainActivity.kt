package com.hieu10.klock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hieu10.klock.ui.components.ThemeSelector
import com.hieu10.klock.ui.components.ThemeToggleButton
import com.hieu10.klock.ui.components.clock.AnalogClock
import com.hieu10.klock.ui.theme.KlockTheme

/**
 * Main Activity demonstrating our theme system
 *
 * EDUCATIONAL NOTE: We now have a fully functional analog clock!
 * This demonstrates how all our components work together to create
 * a complete feature. The clock updates every second using coroutines.
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KlockTheme {
                ScreenContent()
            }
        }
    }
}

@Composable
private fun ScreenContent() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Header with theme toggle
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Klock - Working Clock!",
                    style = MaterialTheme.typography.headlineSmall
                )
                ThemeToggleButton()
            }

            // Main clock display
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                AnalogClock(modifier = Modifier.size(300.dp))
            }

            // Theme selector for testing
            ThemeSelector()

            // Clock info
            Text(
                text = "Features: Live time updates, Theme switching, Custom drawing",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    KlockTheme {
        ScreenContent()
    }
}