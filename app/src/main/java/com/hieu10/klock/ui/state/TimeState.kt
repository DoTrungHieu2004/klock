package com.hieu10.klock.ui.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.hieu10.klock.ui.models.ClockMath
import com.hieu10.klock.ui.models.ClockTime
import kotlinx.coroutines.delay

/**
 * Time State Management
 *
 * EDUCATIONAL NOTE: This demonstrates state hoisting and coroutine-based
 * time updates. We're using Compose's remember and LaunchedEffect for
 * reactive time management that automatically cleans up when the
 * composable leaves the composition.
 */

/**
 * Time state that holds current time and update configuration
 *
 * EDUCATIONAL: Using a stable state holder that can be observed by Compose.
 * The update interval allows us to control performance vs smoothness.
 */
@Stable
class TimeState(
    initialTime: ClockTime = ClockTime.now(),
    val updateInterval: Long = 1000L    // 1 second update from now
) {
    var currentTime by mutableStateOf(initialTime)
        private set

    var isRunning by mutableStateOf(false)
        private set

    /**
     * Starts the time updates using coroutines
     *
     * EDUCATIONAL: We use a LaunchedEffect in the composable to start this,
     * which automatically manages the coroutine lifecycle.
     */
    suspend fun start() {
        isRunning = true
        while (isRunning) {
            currentTime = ClockTime.now()
            delay(updateInterval)
        }
    }

    fun stop() {
        isRunning = false
    }

    /**
     * Calculates hand rotations based on current time
     *
     * EDUCATIONAL: This demonstrates the mathematical conversion from
     * time units to rotational angles. We convert to radians for
     * efficient use in rotation transformations.
     */
    fun calculateHandRotations(): HandRotations {
        val hours = currentTime.hours % 12
        val minutes = currentTime.minutes
        val seconds = currentTime.seconds

        // Calculate angles in radians
        val hourAngle = (hours * ClockMath.DEGREES_PER_HOUR +
                        minutes * 0.5f) * (Math.PI.toFloat() / 180f)
        val minuteAngle = (minutes * ClockMath.DEGREES_PER_MINUTE +
                        seconds * 0.1f) * (Math.PI.toFloat() / 180f)
        val secondAngle = seconds * ClockMath.DEGREES_PER_SECOND * (Math.PI.toFloat() / 180f)

        return HandRotations(hourAngle, minuteAngle, secondAngle)
    }
}

/**
 * Data class for hand rotation values
 */
data class HandRotations(
    val hourRadians: Float,
    val minuteRadians: Float,
    val secondRadians: Float
)

/**
 * Remembers and manages TimeState instance
 *
 * EDUCATIONAL: rememberUpdatedState ensures our time updates don't
 * cause unnecessary recompositions of the entire clock.
 */
@Composable
fun rememberTimeState(updateInterval: Long = 1000L): TimeState {
    val timeState = remember(updateInterval) {
        TimeState(updateInterval = updateInterval)
    }

    // Start time updates when composables enters composition
    LaunchedEffect(timeState) {
        timeState.start()
    }

    // No need to explicitly stop - LaunchedEffect handles cleanup

    return timeState
}