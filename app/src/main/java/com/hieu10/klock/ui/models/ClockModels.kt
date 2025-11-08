package com.hieu10.klock.ui.models

import androidx.compose.ui.graphics.Color
import kotlin.math.PI

/**
 * Clock Data Models and Mathematical Foundations
 *
 * EDUCATIONAL NOTE: These models represent the core data structures
 * for our clock system. We're using value classes and data classes
 * for type safety and performance. The mathematical constants and
 * calculations here form the foundation for all clock animations.
 */

/**
 * Represents a specific moment in time for clock display
 *
 * EDUCATIONAL: Using a value class for performance - no runtime overhead
 * compared to primitive types, but type safety at compile time.
 */
@JvmInline
value class ClockTime(
    val milliseconds: Long
) {
    val hours: Int get() = ((milliseconds / (1000 * 60 * 60)) % 24).toInt()
    val minutes: Int get() = ((milliseconds / (1000 * 60)) % 60).toInt()
    val seconds: Int get() = ((milliseconds / 1000) % 60).toInt()
    val millis: Int get() = (milliseconds % 1000).toInt()

    companion object {
        fun now(): ClockTime = ClockTime(System.currentTimeMillis())
    }
}

/**
 * Mathematical constants for clock calculations.
 *
 * EDUCATIONAL: These constants are fundamental to circular motion
 * and clock mathematics. Using const vals for compile-time optimization.
 */
object ClockMath {
    const val DEGREES_PER_HOUR = 30f    // 360° / 12 hours
    const val DEGREES_PER_MINUTE = 6f   // 360° / 60 minutes
    const val DEGREES_PER_SECOND = 6f   // 360° / 60 seconds

    const val RADIANS_PER_HOUR = (2f * PI / 12).toFloat()
    const val RADIANS_PER_MINUTE = (2f * PI / 60).toFloat()
    const val RADIANS_PER_SECOND = (2f * PI / 60).toFloat()

    // Conversion utilities
    fun degreesToRadians(degrees: Float): Float = (degrees * PI / 180).toFloat()
    fun radiansToDegrees(radians: Float): Float = (radians * 180 / PI).toFloat()
}

/**
 * Configuration for a clock hand's visual appearance
 *
 * EDUCATIONAL: Data classes are perfect for configuration objects
 * because they automatically provide equals, hashCode, toString,
 * and copy methods. This makes them easy to use and debug.
 */
data class HandStyle(
    val length: Float,          // As percentage of clock radius (0-1)
    val width: Float,           // Thickness of the hand
    val color: Color,           // Hand color
    val capStyle: HandCapStyle = HandCapStyle.Round,
    val tailLength: Float = 0f  // Length of hand tail (0-1)
)

/**
 * Different styles for hand endpoints
 */
enum class HandCapStyle {
    Round, Square, Arrow, None
}

/**
 * Represents the position and rotation of a clock hand
 *
 * EDUCATIONAL: This sealed class hierarchy demonstrates how to model
 * different types of clock hands with shared properties but different
 * behaviors. This pattern is extensible for future hand types.
 */
sealed class HandPosition {
    abstract val rotationRadians: Float
    abstract val style: HandStyle

    data class HourHand(
        override val rotationRadians: Float,
        override val style: HandStyle
    ) : HandPosition()

    data class MinuteHand(
        override val rotationRadians: Float,
        override val style: HandStyle
    ) : HandPosition()

    data class SecondHand(
        override val rotationRadians: Float,
        override val style: HandStyle
    ) : HandPosition()
}

/**
 * Complete state of the analog clock
 *
 * EDUCATIONAL: This data class represents the entire visual state
 * of our clock. Using immutable data structures makes our UI predictable
 * and easy to test. The state can be easily serialized or logged.
 */
data class ClockState(
    val time: ClockTime,
    val hourHand: HandPosition.HourHand,
    val minuteHand: HandPosition.MinuteHand,
    val secondHand: HandPosition.SecondHand,
    val isAnimating: Boolean = false
)