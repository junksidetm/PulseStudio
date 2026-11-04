package com.darksidestudio.pulsestudio.ui.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

/**
 * =========================================================================================
 * PULSE STUDIO — MATERIAL 3 EXPRESSIVE SHAPE SYSTEM
 * Source of Truth: https://m3.material.io/styles/shape
 *
 * Implements tactile corner curvature:
 * - Extra Small (4dp): Micro tags, frequency indicators
 * - Small (8dp): Connected settings borders, compact chips
 * - Medium (16dp): Benchmark status cards, modal containers
 * - Large (24dp): FOSS grouped preference cards, playback surfaces
 * - Extra Large (32dp): Hero bento containers, waveform card headers
 * - Full Pill: Filter chips, dynamic version badge, play/pause buttons
 * =========================================================================================
 */
val ExpressiveShapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(32.dp)
)

val ExpressivePillShape = CircleShape
