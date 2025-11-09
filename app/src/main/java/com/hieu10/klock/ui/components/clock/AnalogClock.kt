package com.hieu10.klock.ui.components.clock

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hieu10.klock.ui.models.HandCapStyle
import com.hieu10.klock.ui.models.HandStyle
import com.hieu10.klock.ui.state.TimeState
import com.hieu10.klock.ui.state.rememberTimeState
import com.hieu10.klock.ui.theme.KlockTheme
import com.hieu10.klock.ui.theme.clockColors
import com.hieu10.klock.ui.theme.themeState

/**
 * Main Analog Clock Composable
 *
 * EDUCATIONAL NOTE: This demonstrates component composition - building
 * complex UIs from smaller, focused components. We're using state hoisting
 * to make the clock controllable from parent composables.
 */

/**
 * Complete analog clock with face and hands
 *
 * EDUCATIONAL: This composable brings together all our clock components
 * and manages their layout and coordination. The modifier parameter
 * follows Compose best practices for flexible sizing.
 */
@Composable
fun AnalogClock(
    modifier: Modifier = Modifier,
    timeState: TimeState = rememberTimeState(),
    showSecondHand: Boolean = true,
    handStyles: HandStyles = HandStyles.default()
) {
    val themeState = MaterialTheme.themeState
    val clockColors = clockColors(themeState.isDarkTheme)

    // Calculate current hand rotations
    val handRotations by remember(timeState.currentTime) {
        derivedStateOf { timeState.calculateHandRotations() }
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        // Clock face - drawn first (background)
        ClockFace(
            modifier = Modifier.matchParentSize(),
            showNumbers = true,
            showMinuteMarkers = true,
            showHourMarkers = true
        )

        // Clock hands - drawn on top of face
        ClockHand(
            modifier = Modifier.matchParentSize(),
            rotationRadians = handRotations.hourRadians,
            handStyle = handStyles.hourStyle.copy(color = clockColors.handHour),
            showTail = false
        )

        ClockHand(
            modifier = Modifier.matchParentSize(),
            rotationRadians = handRotations.minuteRadians,
            handStyle = handStyles.minuteStyle.copy(color = clockColors.handMinute),
            showTail = false
        )

        if (showSecondHand) {
            ClockHand(
                modifier = Modifier.matchParentSize(),
                rotationRadians = handRotations.secondRadians,
                handStyle = handStyles.secondStyle.copy(color = clockColors.handSecond),
                showTail = true
            )
        }
    }
}

/**
 * Collection of hand styles for consistent clock appearance
 *
 * EDUCATIONAL: Using a data class to group related configuration
 * makes the API cleaner and ensures visual consistency.
 */
data class HandStyles(
    val hourStyle: HandStyle,
    val minuteStyle: HandStyle,
    val secondStyle: HandStyle
) {
    companion object {
        fun default(): HandStyles {
            return HandStyles(
                hourStyle = HandStyle(
                    length = 0.5f,
                    width = 8f,
                    color = Color.Unspecified,
                    capStyle = HandCapStyle.Round
                ),
                minuteStyle = HandStyle(
                    length = 0.6f,
                    width = 6f,
                    color = Color.Unspecified,
                    capStyle = HandCapStyle.Round
                ),
                secondStyle = HandStyle(
                    length = 0.8f,
                    width = 2f,
                    color = Color.Unspecified,
                    capStyle = HandCapStyle.Arrow,
                    tailLength = 0.1f
                )
            )
        }

        fun modern(): HandStyles {
            return HandStyles(
                hourStyle = HandStyle(
                    length = 0.5f,
                    width = 10f,
                    color = Color.Unspecified,
                    capStyle = HandCapStyle.Square
                ),
                minuteStyle = HandStyle(
                    length = 0.75f,
                    width = 6f,
                    color = Color.Unspecified,
                    capStyle = HandCapStyle.Square
                ),
                secondStyle = HandStyle(
                    length = 0.9f,
                    width = 2f,
                    color = Color.Unspecified,
                    capStyle = HandCapStyle.None,
                    tailLength = 0.2f
                )
            )
        }
    }
}

/**
 * Preview for the complete analog clock
 *
 * EDUCATIONAL: Previews help us verify the integration of all components
 * and catch layout issues early.
 */
@Preview
@Composable
fun AnalogClockPreview() {
    KlockTheme {
        AnalogClock(modifier = Modifier.size(300.dp))
    }
}

@Preview
@Composable
fun AnalogClockModernPreview() {
    KlockTheme {
        AnalogClock(
            modifier = Modifier.size(250.dp),
            handStyles = HandStyles.modern()
        )
    }
}

@Preview
@Composable
fun AnalogClockNoSecondsPreview() {
    KlockTheme {
        AnalogClock(
            modifier = Modifier.size(200.dp),
            showSecondHand = false
        )
    }
}