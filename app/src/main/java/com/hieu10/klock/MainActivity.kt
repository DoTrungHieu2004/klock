package com.hieu10.klock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hieu10.klock.ui.theme.KlockTheme
import com.hieu10.klock.ui.theme.klockTypography

/**
 * Main Activity demonstrating our theme system
 *
 * EDUCATIONAL: Notice how we wrap our entire app in KlockTheme.
 * This makes all theme properties available to every composable.
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            KlockTheme {
                // A simple preview of out theme system
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