package com.darksidestudio.pulsestudio.ui.components

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Connected List Container synthesized directly from DenserMeerkat/June settings architecture.
 * Groups connected settings items inside a 28dp clipped container with 2dp spacing.
 */
@Composable
fun JuneSettingsSection(
    title: String? = null,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        if (!title.isNullOrEmpty()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 6.dp, bottom = 6.dp, top = 4.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(28.dp)),
            verticalArrangement = Arrangement.spacedBy(2.dp),
            content = content
        )
    }
}

/**
 * Connected Setting Item synthesized directly from DenserMeerkat/June (JuneConnectedItem).
 * Provides intelligent adaptive rounded corners based on list position (index/count)
 * and interactive spring corner morphing on touch press.
 */
@Composable
fun JuneSettingsItem(
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    leadingContent: (@Composable () -> Unit)? = null,
    trailingContent: (@Composable () -> Unit)? = null,
    enabled: Boolean = true,
    shape: Shape? = null,
    index: Int? = null,
    count: Int? = null,
    containerColor: Color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f),
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
    onClick: (() -> Unit)? = null,
    content: (@Composable ColumnScope.() -> Unit)? = null
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val isClickable = onClick != null && enabled

    // Interactive spring animation on press (June's signature bouncy tactile feedback)
    val animatedCorner by animateDpAsState(
        targetValue = if (isClickable && isPressed) 28.dp else 8.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessMediumLow
        ),
        label = "juneConnectedItemCornerAnim"
    )

    // Adaptive position-based shape
    val itemShape = remember(index, count, shape, animatedCorner) {
        if (shape != null) {
            shape
        } else if (index != null && count != null) {
            when {
                count <= 1 -> RoundedCornerShape(28.dp)
                index == 0 -> RoundedCornerShape(
                    topStart = 28.dp,
                    topEnd = 28.dp,
                    bottomStart = animatedCorner,
                    bottomEnd = animatedCorner
                )
                index == count - 1 -> RoundedCornerShape(
                    topStart = animatedCorner,
                    topEnd = animatedCorner,
                    bottomStart = 28.dp,
                    bottomEnd = 28.dp
                )
                else -> RoundedCornerShape(animatedCorner)
            }
        } else {
            RoundedCornerShape(12.dp)
        }
    }

    Surface(
        color = containerColor.copy(alpha = if (enabled) 1f else 0.5f),
        shape = itemShape,
        modifier = modifier
            .fillMaxWidth()
            .clip(itemShape)
            .then(
                if (onClick != null) {
                    Modifier.clickable(
                        interactionSource = interactionSource,
                        indication = ripple(),
                        enabled = enabled,
                        onClick = onClick
                    )
                } else Modifier
            )
    ) {
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (leadingContent != null) {
                    Box(
                        modifier = Modifier
                            .padding(end = 14.dp)
                            .defaultMinSize(minWidth = 24.dp, minHeight = 24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        leadingContent()
                    }
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = if (trailingContent != null) 8.dp else 0.dp),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.fillMaxWidth()
                    )
                    if (subtitle != null) {
                        Text(
                            text = subtitle,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                if (trailingContent != null) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(
                        modifier = Modifier.defaultMinSize(minWidth = 36.dp, minHeight = 36.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        trailingContent()
                    }
                }
            }

            // Expandable/nested content inside June connected item
            content?.invoke(this)
        }
    }
}
