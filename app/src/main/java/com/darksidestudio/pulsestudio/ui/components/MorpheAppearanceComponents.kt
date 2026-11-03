package com.darksidestudio.pulsestudio.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Contrast
import androidx.compose.material.icons.rounded.DarkMode
import androidx.compose.material.icons.rounded.GraphicEq
import androidx.compose.material.icons.rounded.LightMode
import androidx.compose.material.icons.rounded.Palette
import androidx.compose.material.icons.rounded.PhoneAndroid
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Enums representing Morphe Manager Appearance Dimensions
 */
enum class MorpheThemeMode(val label: String, val icon: ImageVector) {
    SYSTEM("System", Icons.Rounded.PhoneAndroid),
    LIGHT("Light", Icons.Rounded.LightMode),
    DARK("Dark", Icons.Rounded.DarkMode)
}

enum class MorpheColorStyle(val label: String, val icon: ImageVector) {
    MORPHE("Morphe", Icons.Rounded.Palette),
    DYNAMIC("Dynamic", Icons.Rounded.AutoAwesome),
    MONOCHROME("Mono", Icons.Rounded.Contrast)
}

enum class MorpheAppCardColor(val label: String) {
    DEFAULT("Default"),
    VIBRANT("Vibrant"),
    PASTEL("Pastel"),
    HIGH_CONTRAST("Contrast")
}

enum class MorpheBackgroundType(val label: String, val description: String) {
    RESONANT_WAVE("Resonant Wave", "Audio-reactive harmonic waveform"),
    PARALLAX_GRID("Parallax Grid", "M3 dynamic perspective grid"),
    MATRIX_RAIN("Matrix Rain", "Cyberpunk code rain stream"),
    STARFIELD("Starfield", "Floating harmonic particulate"),
    NONE("Solid Minimal", "Clean flat surface background")
}

data class MorpheAccentColor(val name: String, val color: Color, val hex: String)

val MorpheAccentColors = listOf(
    MorpheAccentColor("Cobalt Blue", Color(0xFF2979FF), "#2979FF"),
    MorpheAccentColor("Neon Cyan", Color(0xFF00E5FF), "#00E5FF"),
    MorpheAccentColor("Violet Indigo", Color(0xFF7C4DFF), "#7C4DFF"),
    MorpheAccentColor("Emerald Green", Color(0xFF00E676), "#00E676"),
    MorpheAccentColor("Sunset Amber", Color(0xFFFFAB00), "#FFAB00"),
    MorpheAccentColor("Crimson Coral", Color(0xFFFF5252), "#FF5252")
)

enum class MorpheAppIconVariant(val label: String, val subtitle: String) {
    DEFAULT_GLOBE("Resonant Globe", "Default adaptive pulse vector"),
    OLED_MINIMAL("OLED Minimal", "Monochrome black & white lineart"),
    CYBERPUNK_NEON("Cyberpunk Neon", "High-contrast cyan & magenta"),
    MIDNIGHT_DARK("Midnight Dark", "Deep indigo subtle gradient")
}

data class MorpheLanguage(val code: String, val flag: String, val displayName: String)

val MorpheLanguages = listOf(
    MorpheLanguage("en-US", "\uD83C\uDDFA\uD83C\uDDF8", "English (United States)"),
    MorpheLanguage("ja-JP", "\uD83C\uDDEF\uD83C\uDDF5", "Japanese (\u65E5\u672C\u8A9E)"),
    MorpheLanguage("de-DE", "\uD83C\uDDE9\uD83C\uDDEA", "German (Deutsch)"),
    MorpheLanguage("fr-FR", "\uD83C\uDDE8\uD83C\uDDF7", "French (Fran\u00E7ais)"),
    MorpheLanguage("es-ES", "\uD83C\uDDEA\uD83C\uDDF8", "Spanish (Espa\u00F1ol)")
)

/**
 * Morphe Manager Live Preview Card (PreviewAppCard)
 * Renders real-time styling effects reflecting selected theme, accent, and card colors.
 */
@Composable
fun MorphePreviewCard(
    themeMode: MorpheThemeMode,
    colorStyle: MorpheColorStyle,
    accentColor: MorpheAccentColor,
    cardColorMode: MorpheAppCardColor,
    pureBlack: Boolean,
    outlines: Boolean,
    modifier: Modifier = Modifier
) {
    val isDark = themeMode == MorpheThemeMode.DARK || (themeMode == MorpheThemeMode.SYSTEM)
    val cardBackground = when {
        isDark && pureBlack -> Color.Black
        isDark -> Color(0xFF1E1E24)
        else -> Color(0xFFF7F2FA)
    }

    val gradientBrush = when (cardColorMode) {
        MorpheAppCardColor.DEFAULT -> Brush.horizontalGradient(
            listOf(accentColor.color.copy(alpha = 0.85f), accentColor.color.copy(alpha = 0.35f))
        )
        MorpheAppCardColor.VIBRANT -> Brush.horizontalGradient(
            listOf(accentColor.color, Color(0xFFFF5252).copy(alpha = 0.8f))
        )
        MorpheAppCardColor.PASTEL -> Brush.horizontalGradient(
            listOf(accentColor.color.copy(alpha = 0.45f), Color(0xFFB388FF).copy(alpha = 0.35f))
        )
        MorpheAppCardColor.HIGH_CONTRAST -> Brush.horizontalGradient(
            listOf(accentColor.color, accentColor.color)
        )
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .then(
                if (outlines) Modifier.border(
                    1.dp,
                    MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
                    RoundedCornerShape(20.dp)
                ) else Modifier
            ),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = cardBackground),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Gradient header accent bar (Morphe card style)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(CircleShape)
                    .background(gradientBrush)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // App Icon Badge
                Box(
                    modifier = Modifier
                        .size(46.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(accentColor.color.copy(alpha = 0.18f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Rounded.GraphicEq,
                        contentDescription = null,
                        tint = accentColor.color,
                        modifier = Modifier.size(26.dp)
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Pulse Studio",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = if (isDark) Color.White else Color(0xFF1C1B1F)
                    )
                    Text(
                        text = "Engine v1.3.0-dev01 • ${colorStyle.label} Mode",
                        style = MaterialTheme.typography.bodySmall,
                        color = if (isDark) Color(0xFFCAC4D0) else Color(0xFF49454F)
                    )
                }

                // Status Pill
                Surface(
                    shape = CircleShape,
                    color = accentColor.color
                ) {
                    Text(
                        text = "READY",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Live preview of appearance preferences, dynamic surface tinting, and typography density.",
                style = MaterialTheme.typography.bodySmall,
                color = if (isDark) Color(0xFF938F99) else Color(0xFF79747E)
            )
        }
    }
}

/**
 * Morphe ThemeSelector Component:
 * Compact tiles for Theme Mode (System, Light, Dark) and Color Style (Morphe, Dynamic, Monochrome).
 */
@Composable
fun MorpheThemeSelector(
    selectedTheme: MorpheThemeMode,
    onThemeSelected: (MorpheThemeMode) -> Unit,
    selectedStyle: MorpheColorStyle,
    onStyleSelected: (MorpheColorStyle) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // 1. Theme Mode Row
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "Theme Mode",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    MorpheThemeMode.entries.forEach { mode ->
                        val isSelected = selectedTheme == mode
                        val animatedBg by animateColorAsState(
                            targetValue = if (isSelected) MaterialTheme.colorScheme.primaryContainer
                            else MaterialTheme.colorScheme.surface.copy(alpha = 0.5f),
                            animationSpec = tween(200),
                            label = "theme_bg"
                        )
                        val animatedContentColor by animateColorAsState(
                            targetValue = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer
                            else MaterialTheme.colorScheme.onSurfaceVariant,
                            animationSpec = tween(200),
                            label = "theme_color"
                        )

                        Surface(
                            modifier = Modifier
                                .weight(1f)
                                .height(56.dp)
                                .clickable { onThemeSelected(mode) },
                            shape = RoundedCornerShape(14.dp),
                            color = animatedBg,
                            border = if (isSelected) androidx.compose.foundation.BorderStroke(
                                1.5.dp,
                                MaterialTheme.colorScheme.primary
                            ) else null
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    imageVector = mode.icon,
                                    contentDescription = mode.label,
                                    tint = animatedContentColor,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = mode.label,
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                    color = animatedContentColor
                                )
                            }
                        }
                    }
                }
            }

            // 2. Color Style Row
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "Color Style",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    MorpheColorStyle.entries.forEach { style ->
                        val isSelected = selectedStyle == style
                        val animatedBg by animateColorAsState(
                            targetValue = if (isSelected) MaterialTheme.colorScheme.secondaryContainer
                            else MaterialTheme.colorScheme.surface.copy(alpha = 0.5f),
                            animationSpec = tween(200),
                            label = "style_bg"
                        )
                        val animatedContentColor by animateColorAsState(
                            targetValue = if (isSelected) MaterialTheme.colorScheme.onSecondaryContainer
                            else MaterialTheme.colorScheme.onSurfaceVariant,
                            animationSpec = tween(200),
                            label = "style_color"
                        )

                        Surface(
                            modifier = Modifier
                                .weight(1f)
                                .height(56.dp)
                                .clickable { onStyleSelected(style) },
                            shape = RoundedCornerShape(14.dp),
                            color = animatedBg,
                            border = if (isSelected) androidx.compose.foundation.BorderStroke(
                                1.5.dp,
                                MaterialTheme.colorScheme.secondary
                            ) else null
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    imageVector = style.icon,
                                    contentDescription = style.label,
                                    tint = animatedContentColor,
                                    modifier = Modifier.size(20.dp)
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = style.label,
                                    style = MaterialTheme.typography.labelSmall,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                    color = animatedContentColor
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * Morphe AccentColorSelector Component:
 * Swatches row for selecting custom accent colors.
 */
@Composable
fun MorpheAccentColorPicker(
    selectedAccent: MorpheAccentColor,
    onAccentSelected: (MorpheAccentColor) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Accent Color",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = selectedAccent.name,
                    style = MaterialTheme.typography.labelMedium,
                    color = selectedAccent.color,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                MorpheAccentColors.forEach { accent ->
                    val isSelected = accent.name == selectedAccent.name
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .background(accent.color)
                            .clickable { onAccentSelected(accent) }
                            .then(
                                if (isSelected) Modifier.border(3.dp, MaterialTheme.colorScheme.surface, CircleShape)
                                else Modifier
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        if (isSelected) {
                            Icon(
                                imageVector = Icons.Rounded.Check,
                                contentDescription = "Selected",
                                tint = Color.White,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

/**
 * Morphe UiScaleSetting Component:
 * Slider allowing scaling factor between 85% and 115% with Apply and Reset buttons.
 */
@Composable
fun MorpheUiScaleSetting(
    currentScale: Float,
    onApplyScale: (Float) -> Unit,
    onResetScale: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "UI Scale",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Relative typography and component density",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Text(
                        text = "${(currentScale * 100).toInt()}%",
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Slider(
                value = currentScale,
                onValueChange = onApplyScale,
                valueRange = 0.85f..1.15f,
                steps = 5,
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FilledTonalButton(
                    onClick = { onApplyScale(currentScale) },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.CheckCircle,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Apply", style = MaterialTheme.typography.labelMedium)
                }

                OutlinedButton(
                    onClick = onResetScale,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Refresh,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Reset (100%)", style = MaterialTheme.typography.labelMedium)
                }
            }
        }
    }
}

/**
 * Dialog for App Language Selection
 */
@Composable
fun MorpheLanguageDialog(
    currentLanguage: MorpheLanguage,
    onLanguageSelected: (MorpheLanguage) -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "Select Language",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                MorpheLanguages.forEach { language ->
                    val isSelected = language.code == currentLanguage.code
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .clickable {
                                onLanguageSelected(language)
                                onDismiss()
                            },
                        color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else Color.Transparent
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp, vertical = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = language.flag, fontSize = 22.sp)
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = language.displayName,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.weight(1f)
                            )
                            if (isSelected) {
                                Icon(
                                    imageVector = Icons.Rounded.Check,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Close")
            }
        }
    )
}

/**
 * Dialog for App Icon Variant Selection
 */
@Composable
fun MorpheAppIconDialog(
    currentVariant: MorpheAppIconVariant,
    onVariantSelected: (MorpheAppIconVariant) -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "Launcher App Icon",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                MorpheAppIconVariant.entries.forEach { variant ->
                    val isSelected = variant == currentVariant
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .clickable {
                                onVariantSelected(variant)
                                onDismiss()
                            },
                        color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else Color.Transparent
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp, vertical = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(
                                        when (variant) {
                                            MorpheAppIconVariant.DEFAULT_GLOBE -> Color(0xFF2979FF)
                                            MorpheAppIconVariant.OLED_MINIMAL -> Color.Black
                                            MorpheAppIconVariant.CYBERPUNK_NEON -> Color(0xFF00E5FF)
                                            MorpheAppIconVariant.MIDNIGHT_DARK -> Color(0xFF311B92)
                                        }
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.GraphicEq,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = variant.label,
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                    color = if (isSelected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = variant.subtitle,
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            if (isSelected) {
                                Icon(
                                    imageVector = Icons.Rounded.Check,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Close")
            }
        }
    )
}
