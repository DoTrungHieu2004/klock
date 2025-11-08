package com.hieu10.klock.ui.components.clock

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hieu10.klock.ui.models.HandCapStyle
import com.hieu10.klock.ui.models.HandStyle
import com.hieu10.klock.ui.theme.KlockTheme
import kotlin.math.PI

/**
 * Clock Hand Component
 *
 * EDUCATIONAL NOTE: This component demonstrates how to create
 * reusable, configurable components in Compose. The hand uses
 * rotation transformations and custom path drawing to create
 * different hand styles and appearances.
 */

/**
 * Draw a single clock hand with configurable style and rotation
 *
 * EDUCATIONAL: The rotate() function is DrawScope automatically
 * handles the transformation matrix for rotation around the center.
 * This is much more efficient than manually calculating positions.
 */
@Composable
fun ClockHand(
    modifier: Modifier = Modifier,
    rotationRadians: Float,
    handStyle: HandStyle,
    showTail: Boolean = false
) {
    Canvas(modifier = modifier) {
        val center = Offset(size.width / 2, size.height / 2)
        val radius = size.minDimension / 2

        // Apply rotation around the center
        rotate(
            degrees = (rotationRadians * 180 / PI.toFloat()) + 90f, // Start from 12 o'clock
            pivot = center
        ) {
            drawHand(center, radius, handStyle, showTail)
        }
    }
}

/**
 * Draws the hand based on the specified style
 *
 * EDUCATIONAL: We use different drawing techniques based on the
 * hand style. This shows how to create flexible components that
 * can handle multiple visual representations.
 */
private fun DrawScope.drawHand(
    center: Offset,
    radius: Float,
    handStyle: HandStyle,
    showTail: Boolean
) {
    val handLength = radius * handStyle.length
    val handWidth = handStyle.width
    val tailLength = if (showTail) radius * handStyle.tailLength else 0f

    // Draw hand tail (opposite direction from main hand)
    if (showTail && tailLength > 0) {
        drawLine(
            color = handStyle.color,
            start = center,
            end = Offset(center.x, center.y - tailLength),
            strokeWidth = handWidth / 2,
            alpha = 0.7f
        )
    }

    // Draw main hand
    drawLine(
        color = handStyle.color,
        start = center,
        end = Offset(center.x, center.y - handLength),
        strokeWidth = handWidth
    )

    // Draw hand cap based on style
    drawHandCap(center, handLength, handStyle)
}

/**
 * Draws different cap styles at the end of the hand
 *
 * EDUCATIONAL: This demonstrates how to create different visual
 * styles using the same base component. Each cap style uses
 * different drawing primitives.
 */
private fun DrawScope.drawHandCap(
    center: Offset,
    handLength: Float,
    handStyle: HandStyle
) {
    val endPoint = Offset(center.x, center.y - handLength)

    when (handStyle.capStyle) {
        HandCapStyle.Round -> {
            drawCircle(
                color = handStyle.color,
                center = endPoint,
                radius = handStyle.width * 1.5f
            )
        }
        HandCapStyle.Square -> {
            val squareSize = handStyle.width * 2
            drawRect(
                color = handStyle.color,
                topLeft = Offset(endPoint.x - squareSize / 2, endPoint.y - squareSize / 2),
                size = Size(squareSize, squareSize)
            )
        }
        HandCapStyle.Arrow -> {
            // Simple arrow implementation
            val arrowSize = handStyle.width * 3
            drawCircle(
                color = handStyle.color,
                center = endPoint,
                radius = arrowSize / 2
            )
        }
        HandCapStyle.None -> {}
    }
}

/**
 * Preview for individual clock hands
 *
 * EDUCATIONAL: Testing each hand in isolation helps catch
 * drawing issues before integrating into the complete clock.
 */
@Preview
@Composable
fun ClockHandPreview() {
    KlockTheme {
        ClockHand(
            modifier = Modifier.size(200.dp),
            rotationRadians = (45f * PI / 180).toFloat(),   // 45 degrees
            handStyle = HandStyle(
                length = 0.6f,
                width = 8f,
                color = Color(0xFF2E5C8B),
                capStyle = HandCapStyle.Round
            )
        )
    }
}

@Preview
@Composable
fun ClockHandWithTailPreview() {
    KlockTheme {
        ClockHand(
            modifier = Modifier.size(200.dp),
            rotationRadians = (120f * PI / 180).toFloat(),   // 45 degrees
            handStyle = HandStyle(
                length = 0.7f,
                width = 6f,
                color = Color(0xFFD84315),
                capStyle = HandCapStyle.Arrow,
                tailLength = 0.2f
            ),
            showTail = true
        )
    }
}