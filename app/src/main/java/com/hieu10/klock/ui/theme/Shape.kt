package com.hieu10.klock.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

/**
 * Klock Shape System
 *
 * EDUCATIONAL NOTE: Shapes create visual hierarchy and brand identity.
 * We use consistent corner radii across components to maintain visual harmony.
 * The shape scale follows a geometric progression for consistency.
 */

val KlockShape = Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(16.dp),
    extraLarge = RoundedCornerShape(28.dp)
)

// Clock-specific shapes
val ClockFaceShapes = RoundedCornerShape(50)    // Circular shape for clock face
val HandCapShape = RoundedCornerShape(50)       // Circular shape for hand caps