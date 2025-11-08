package com.hieu10.klock.ui.components.clock

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hieu10.klock.ui.theme.KlockTheme
import com.hieu10.klock.ui.theme.clockColors
import com.hieu10.klock.ui.theme.themeState
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

/**
 * Clock Face Component
 *
 * EDUCATIONAL NOTE: This component demonstrates custom drawing with
 * Jetpack Compose Canvas. We're using mathematical calculations to
 * position markers and numbers around the clock face. The coordinate
 * system starts at the top-left, so we need to translate to the center.
 */

/**
 * Main clock face component with markers and numbers
 *
 * EDUCATIONAL: The Canvas composable gives us a DrawScope where we
 * can perform low-level drawing operations. We use mathematical
 * transformations to create the circular layout of markers.
 */
@Composable
fun ClockFace(
    modifier: Modifier = Modifier,
    showNumbers: Boolean = true,
    showMinuteMarkers: Boolean = true,
    showHourMarkers: Boolean = true
) {
    val themeState = MaterialTheme.themeState
    val clockColors = clockColors(themeState.isDarkTheme)

    Canvas(modifier = modifier) {
        val center = Offset(size.width / 2, size.height / 2)
        val radius = size.minDimension / 2

        // Draw clock face background
        drawClockFaceBackground(center, radius, clockColors.faceBackground)

        // Draw markers
        if (showMinuteMarkers) {
            drawMinuteMarkers(center, radius, clockColors.markers)
        }

        if (showHourMarkers) {
            drawHourMarkers(center, radius, clockColors.markers)
        }

        // Draw numbers
        if (showNumbers) {
            drawHourNumbers(center, radius, clockColors.text)
        }

        // Draw center cap
        drawCenterCap(center, clockColors.markers)
    }
}

/**
 * Draws the circular background of the clock face
 *
 * EDUCATIONAL: drawCircle is optimized for drawing circles. We use
 * the center and radius calculated from the canvas size to ensure
 * the clock is properly centered and scaled.
 */
private fun DrawScope.drawClockFaceBackground(
    center: Offset,
    radius: Float,
    color: Color
) {
    drawCircle(
        color = color,
        center = center,
        radius = radius,
        alpha = 0.9f
    )
}

/**
 * Draws minute markers (60 markers around the clock)
 *
 * EDUCATIONAL: We use trigonometric functions (cos/sin) to calculate
 * positions around the circle. Each marker is rotated by 6 degrees
 * (360° / 60 markers). This demonstrates polar coordinate mathematics.
 */
private fun DrawScope.drawMinuteMarkers(
    center: Offset,
    radius: Float,
    color: Color
) {
    for (minute in 0 until 60) {
        // Skip positions that have hour markers to avoid overdraw
        if (minute % 5 == 0) continue

        val angle = (minute * 6f - 90f) * (PI.toFloat() / 180f)
        val start = Offset(
            x = center.x + (radius - 20) * cos(angle),
            y = center.y + (radius - 20) * sin(angle)
        )
        val end = Offset(
            x = center.x + (radius - 10) * cos(angle),
            y = center.y + (radius - 10) * sin(angle)
        )

        drawLine(
            color = color,
            start = start,
            end = end,
            strokeWidth = 1.dp.toPx(),
            alpha = 0.6f
        )
    }
}

/**
 * Draws hour markers (12 markers at each hour position)
 *
 * EDUCATIONAL: Hour markers are thicker and longer than minute markers.
 * We use the same trigonometric approach but with 30-degree increments
 * (360° / 12 hours). This shows how to create visual hierarchy.
 */
private fun DrawScope.drawHourMarkers(
    center: Offset,
    radius: Float,
    color: Color
) {
    for (hour in 0 until 12) {
        val angle = (hour * 30f - 90f) * (PI.toFloat() / 180f)
        val start = Offset(
            x = center.x + (radius - 25) * cos(angle),
            y = center.y + (radius - 25) * sin(angle)
        )
        val end = Offset(
            x = center.x + (radius - 10) * cos(angle),
            y = center.y + (radius - 10) * sin(angle)
        )

        drawLine(
            color = color,
            start = start,
            end = end,
            strokeWidth = 3.dp.toPx(),
            alpha = 0.8f
        )
    }
}

/**
 * Draws hour numbers (1-12) around the clock face
 *
 * EDUCATIONAL: This demonstrates text drawing in custom layouts.
 * We need to account for text size and alignment to properly
 * position numbers. The text is drawn using the theme's typography.
 */
private fun DrawScope.drawHourNumbers(
    center: Offset,
    radius: Float,
    color: Color
) {
    val textPaint = Paint().asFrameworkPaint().apply {
        this.color = color.toArgb()
        textSize = 36f
        textAlign = android.graphics.Paint.Align.CENTER
    }

    for (hour in 1..12) {
        val angle = (hour * 30f - 90f) * (PI.toFloat() / 180f)
        val numberRadius = radius - 90

        val x = center.x + numberRadius * cos(angle)
        val y = center.y + numberRadius * sin(angle)

        // Adjust for text baseline
        val textOffset = Offset(x, y + textPaint.textSize / 3)

        drawContext.canvas.nativeCanvas.drawText(
            hour.toString(),
            textOffset.x,
            textOffset.y,
            textPaint
        )
    }
}

/**
 * Draws the center cap that covers the hand pivots
 *
 * EDUCATIONAL: Even small details like the center cap contribute
 * to the overall polish of the component. This shows attention
 * to detail in custom drawing.
 */
private fun DrawScope.drawCenterCap(
    center: Offset,
    color: Color
) {
    drawCircle(
        color = color,
        center = center,
        radius = 8.dp.toPx()
    )
}

/**
 * Preview for the clock face component
 *
 * EDUCATIONAL: Previews allow us to visually test our component
 * in isolation. We test different configurations and themes.
 */
@Preview
@Composable
fun ClockFacePreview() {
    KlockTheme {
        ClockFace(
            modifier = Modifier.size(300.dp),
            showNumbers = true,
            showMinuteMarkers = true,
            showHourMarkers = true
        )
    }
}

@Preview
@Composable
fun ClockFaceSimplePreview() {
    KlockTheme {
        ClockFace(
            modifier = Modifier.size(300.dp),
            showNumbers = false,
            showMinuteMarkers = false,
            showHourMarkers = true
        )
    }
}