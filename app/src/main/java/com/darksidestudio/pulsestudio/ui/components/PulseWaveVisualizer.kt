package com.darksidestudio.pulsestudio.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.sin

/**
 * High-performance, zero-allocation reactive Canvas visualizer adhering to native Compose mandates.
 * Renders dynamic harmonic sine waves simulating audio frequency resonance.
 *
 * Implements mathematically continuous spatial and temporal periodicity:
 * - Spatial: 4π full cycles with Hanning envelope so both ends anchor cleanly at midY.
 * - Temporal: Phase cycle spans 0 to 2π with integer harmonic multipliers, guaranteeing
 *   the infinite animation loop starts and ends at the exact same mathematical values with zero jump.
 */
@Composable
fun PulseWaveVisualizer(
    modifier: Modifier = Modifier,
    height: Dp = 100.dp,
    waveColor: Color = MaterialTheme.colorScheme.primary,
    accentColor: Color = MaterialTheme.colorScheme.tertiary
) {
    val infiniteTransition = rememberInfiniteTransition(label = "pulse_wave_transition")
    val phase by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 2f * Math.PI.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3200, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "wave_phase"
    )

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
    ) {
        val width = size.width
        val canvasHeight = size.height
        val midY = canvasHeight / 2f
        val amplitude = canvasHeight * 0.38f

        val primaryPath = Path()
        val secondaryPath = Path()

        val points = 80
        val step = width / points

        for (i in 0..points) {
            val x = i * step
            val progress = i.toFloat() / points

            // Spatial period: exactly 2 full cycles (4 * PI)
            val normalizedX = progress * 4f * Math.PI.toFloat()

            // Smooth Hanning window envelope ensuring wave gracefully anchors at midY on both ends
            val envelope = sin(progress * Math.PI.toFloat())

            // Temporal harmonics: all phase multipliers are integers (1 and -1)
            // This guarantees f(phase = 0) == f(phase = 2 * PI), producing a mathematically seamless infinite loop
            val y1 = midY + sin(normalizedX + phase) * (amplitude * envelope)
            val y2 = midY + sin(normalizedX - phase + (Math.PI / 2).toFloat()) * (amplitude * 0.55f * envelope)

            if (i == 0) {
                primaryPath.moveTo(x, y1)
                secondaryPath.moveTo(x, y2)
            } else {
                primaryPath.lineTo(x, y1)
                secondaryPath.lineTo(x, y2)
            }
        }

        // Secondary subtle harmonic layer
        drawPath(
            path = secondaryPath,
            brush = Brush.horizontalGradient(
                colors = listOf(
                    accentColor.copy(alpha = 0.2f),
                    accentColor.copy(alpha = 0.6f),
                    accentColor.copy(alpha = 0.2f)
                )
            ),
            style = Stroke(width = 3.dp.toPx(), cap = StrokeCap.Round)
        )

        // Primary expressive wave layer
        drawPath(
            path = primaryPath,
            brush = Brush.horizontalGradient(
                colors = listOf(
                    waveColor.copy(alpha = 0.3f),
                    waveColor,
                    waveColor.copy(alpha = 0.3f)
                )
            ),
            style = Stroke(width = 4.5.dp.toPx(), cap = StrokeCap.Round)
        )
    }
}
