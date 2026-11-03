package com.darksidestudio.pulsestudio.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Apps
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material.icons.rounded.AutoFixHigh
import androidx.compose.material.icons.rounded.BlurOn
import androidx.compose.material.icons.rounded.BorderStyle
import androidx.compose.material.icons.rounded.ChatBubble
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Contrast
import androidx.compose.material.icons.rounded.Equalizer
import androidx.compose.material.icons.rounded.Extension
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.FormatColorFill
import androidx.compose.material.icons.rounded.GraphicEq
import androidx.compose.material.icons.rounded.Keyboard
import androidx.compose.material.icons.rounded.Language
import androidx.compose.material.icons.rounded.Movie
import androidx.compose.material.icons.rounded.MusicNote
import androidx.compose.material.icons.rounded.Palette
import androidx.compose.material.icons.rounded.Pause
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.RadioButtonChecked
import androidx.compose.material.icons.rounded.RadioButtonUnchecked
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Security
import androidx.compose.material.icons.rounded.Speed
import androidx.compose.material.icons.rounded.TextFields
import androidx.compose.material.icons.rounded.Tune
import androidx.compose.material.icons.rounded.Vibration
import androidx.compose.material.icons.rounded.Wallpaper
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darksidestudio.pulsestudio.data.MockDataProvider
import com.darksidestudio.pulsestudio.ui.components.JuneSettingsItem
import com.darksidestudio.pulsestudio.ui.components.JuneSettingsSection
import com.darksidestudio.pulsestudio.ui.components.MaterialChevron
import com.darksidestudio.pulsestudio.ui.components.MorpheAccentColor
import com.darksidestudio.pulsestudio.ui.components.MorpheAccentColorPicker
import com.darksidestudio.pulsestudio.ui.components.MorpheAccentColors
import com.darksidestudio.pulsestudio.ui.components.MorpheAppCardColor
import com.darksidestudio.pulsestudio.ui.components.MorpheAppIconDialog
import com.darksidestudio.pulsestudio.ui.components.MorpheAppIconVariant
import com.darksidestudio.pulsestudio.ui.components.MorpheBackgroundType
import com.darksidestudio.pulsestudio.ui.components.MorpheColorStyle
import com.darksidestudio.pulsestudio.ui.components.MorpheLanguage
import com.darksidestudio.pulsestudio.ui.components.MorpheLanguageDialog
import com.darksidestudio.pulsestudio.ui.components.MorpheLanguages
import com.darksidestudio.pulsestudio.ui.components.MorphePreviewCard
import com.darksidestudio.pulsestudio.ui.components.MorpheThemeMode
import com.darksidestudio.pulsestudio.ui.components.MorpheThemeSelector
import com.darksidestudio.pulsestudio.ui.components.MorpheUiScaleSetting
import kotlinx.coroutines.launch

/**
 * "The Other's Way" Screen:
 * Renders the EXACT IDENTICAL Unified Studio Dataset using the Open Source Community's
 * Material 3 Design Patterns:
 * - MorpheApp/morphe-manager: Complete Appearance Architecture (ThemeSelector, AccentColorSelector,
 *   PreviewAppCard, UiScaleSetting, AppCardColor, Language & App Icon Customization)
 * - DenserMeerkat/June: Connected settings lists with 28dp/8dp adaptive corners and tactile spring physics
 * - cromaguy/Rhythm: Docked mini-player bar with live progress indicator and playback toggle
 * - marlboro-advance/mpvEx: Segmented rate buttons and dropdown media selector
 * - junksidetm/Gboard-patches: Vector chevrons, hairline dividers, and switches with checkmark thumbs
 * - morpheapp/microg-RE: System service status banners and indicators
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun OthersWayScreen(
    onNavigateBack: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()

    // Unified Mock State (IDENTICAL to AI Way)
    val track = MockDataProvider.activeTrack
    var isPlaying by remember { mutableStateOf(true) }
    var isFavorite by remember { mutableStateOf(track.isFavorite) }

    // Category Filter Chips
    var selectedCategory by remember { mutableStateOf("All") }

    // Search query
    var searchQuery by remember { mutableStateOf("") }

    // DSP Tuning Sliders
    var spatialResonance by remember { mutableFloatStateOf(0.78f) }
    var hapticIntensity by remember { mutableFloatStateOf(0.65f) }

    // Playback Speed
    val speeds = MockDataProvider.playbackSpeeds
    var selectedSpeedIndex by remember { mutableIntStateOf(1) }

    // Audio Stream Track & Dropdown Menu
    val audioTracks = MockDataProvider.audioTracks
    var selectedAudioTrack by remember { mutableStateOf(audioTracks.first()) }
    var isAudioMenuOpen by remember { mutableStateOf(false) }

    // Studio Preset Selection (Radio Group)
    val presets = MockDataProvider.studioPresets
    var selectedPresetId by remember { mutableStateOf(presets.first().id) }

    // System Modules Toggle States
    val modules = MockDataProvider.studioModules
    var moduleStates by remember { mutableStateOf(modules.associate { it.id to it.isEnabled }) }

    // Morphe Manager Appearance State
    var themeMode by remember { mutableStateOf(MorpheThemeMode.SYSTEM) }
    var colorStyle by remember { mutableStateOf(MorpheColorStyle.MORPHE) }
    var selectedAccent by remember { mutableStateOf(MorpheAccentColors.first()) }
    var cardColorMode by remember { mutableStateOf(MorpheAppCardColor.DEFAULT) }
    var pureBlackTheme by remember { mutableStateOf(false) }
    var colorAccents by remember { mutableStateOf(true) }
    var uiScale by remember { mutableFloatStateOf(1.0f) }
    var selectedLanguage by remember { mutableStateOf(MorpheLanguages.first()) }
    var selectedAppIcon by remember { mutableStateOf(MorpheAppIconVariant.DEFAULT_GLOBE) }
    var outlines by remember { mutableStateOf(false) }
    var blur by remember { mutableStateOf(true) }
    var backgroundType by remember { mutableStateOf(MorpheBackgroundType.RESONANT_WAVE) }
    var showGreetingPhrases by remember { mutableStateOf(true) }
    var showRepatchNotice by remember { mutableStateOf(true) }
    var showMoreAppsCard by remember { mutableStateOf(true) }

    // Dialog Visibility State
    var showLanguageDialog by remember { mutableStateOf(false) }
    var showAppIconDialog by remember { mutableStateOf(false) }

    // Modal Bottom Sheet State
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var isBottomSheetOpen by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Pulse Studio",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Other's Way • Community M3 Synthesis",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    Surface(
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        modifier = Modifier.padding(end = 12.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colorScheme.secondary)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "COMMUNITY",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSecondaryContainer,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        bottomBar = {
            // Rhythm Inspired Mini-Player Bar
            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.surfaceVariant,
                shadowElevation = 8.dp,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            ) {
                Column {
                    LinearProgressIndicator(
                        progress = { 0.42f },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(2.5.dp),
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(MaterialTheme.colorScheme.primaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.MusicNote,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                                modifier = Modifier.size(22.dp)
                            )
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = track.title,
                                style = MaterialTheme.typography.titleMedium.copy(fontSize = 14.sp),
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "${track.artist} • ${track.bitrate}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        IconButton(onClick = { isFavorite = !isFavorite }) {
                            Icon(
                                imageVector = if (isFavorite) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                                contentDescription = "Favorite",
                                tint = if (isFavorite) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        IconButton(onClick = { isPlaying = !isPlaying }) {
                            Icon(
                                imageVector = if (isPlaying) Icons.Rounded.Pause else Icons.Rounded.PlayArrow,
                                contentDescription = "Play/Pause"
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(4.dp))

                // June Inspired Pill Search Bar
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(
                            text = "Search presets, modules, frequencies...",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = "Search",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { searchQuery = "" }) {
                                Icon(
                                    imageVector = Icons.Rounded.Close,
                                    contentDescription = "Clear search"
                                )
                            }
                        }
                    },
                    singleLine = true,
                    shape = CircleShape,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = Color.Transparent,
                        focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f),
                        unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f)
                    )
                )
            }

            // 1. microg-RE Inspired Status Banner
            item {
                JuneSettingsSection {
                    JuneSettingsItem(
                        title = "Core Environment Active",
                        subtitle = "microG Core • Gboard Engine • Morphe Appearance Loaded",
                        index = 0,
                        count = 1,
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Rounded.CheckCircle,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        trailingContent = {
                            Surface(
                                shape = CircleShape,
                                color = MaterialTheme.colorScheme.primary
                            ) {
                                Text(
                                    text = "ONLINE",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    )
                }
            }

            // 2. MORPHE MANAGER: LIVE PREVIEW CARD
            item {
                Column {
                    Text(
                        text = "LIVE THEME PREVIEW (MORPHE MANAGER)",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 6.dp, bottom = 6.dp, top = 2.dp)
                    )
                    MorphePreviewCard(
                        themeMode = themeMode,
                        colorStyle = colorStyle,
                        accentColor = selectedAccent,
                        cardColorMode = cardColorMode,
                        pureBlack = pureBlackTheme,
                        outlines = outlines
                    )
                }
            }

            // 3. MORPHE MANAGER: THEME & COLOR STYLES
            item {
                JuneSettingsSection(title = "THEME & COLOR STYLES (MORPHE MANAGER)") {
                    // Theme and Style Segmented Row
                    JuneSettingsItem(
                        title = "Theme Mode & Palette Style",
                        subtitle = "${themeMode.label} • ${colorStyle.label}",
                        index = 0,
                        count = 4,
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Rounded.Palette,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        content = {
                            Spacer(modifier = Modifier.height(8.dp))
                            MorpheThemeSelector(
                                selectedTheme = themeMode,
                                onThemeSelected = { themeMode = it },
                                selectedStyle = colorStyle,
                                onStyleSelected = { colorStyle = it }
                            )
                            if (colorStyle != MorpheColorStyle.DYNAMIC) {
                                Spacer(modifier = Modifier.height(10.dp))
                                MorpheAccentColorPicker(
                                    selectedAccent = selectedAccent,
                                    onAccentSelected = { selectedAccent = it }
                                )
                            }
                        }
                    )

                    // Pure Black OLED Switch
                    JuneSettingsItem(
                        title = "Pure Black (OLED)",
                        subtitle = "Deep OLED pitch black (#000000) for surfaces in dark mode",
                        index = 1,
                        count = 4,
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Rounded.Contrast,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        trailingContent = {
                            Switch(
                                checked = pureBlackTheme,
                                onCheckedChange = { pureBlackTheme = it },
                                thumbContent = if (pureBlackTheme) {
                                    {
                                        Icon(
                                            imageVector = Icons.Rounded.Check,
                                            contentDescription = null,
                                            modifier = Modifier.size(SwitchDefaults.IconSize)
                                        )
                                    }
                                } else null
                            )
                        },
                        onClick = { pureBlackTheme = !pureBlackTheme }
                    )

                    // Color Accents Switch
                    JuneSettingsItem(
                        title = "Color Accents",
                        subtitle = "Tint surface controls, badges, and sliders with active accent",
                        index = 2,
                        count = 4,
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Rounded.FormatColorFill,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        trailingContent = {
                            Switch(
                                checked = colorAccents,
                                onCheckedChange = { colorAccents = it },
                                thumbContent = if (colorAccents) {
                                    {
                                        Icon(
                                            imageVector = Icons.Rounded.Check,
                                            contentDescription = null,
                                            modifier = Modifier.size(SwitchDefaults.IconSize)
                                        )
                                    }
                                } else null
                            )
                        },
                        onClick = { colorAccents = !colorAccents }
                    )

                    // App Card Colors Palette Mode
                    JuneSettingsItem(
                        title = "App Card Color Palette",
                        subtitle = "Active: ${cardColorMode.label} Gradient",
                        index = 3,
                        count = 4,
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Rounded.AutoAwesome,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        content = {
                            Spacer(modifier = Modifier.height(8.dp))
                            SingleChoiceSegmentedButtonRow(modifier = Modifier.fillMaxWidth()) {
                                MorpheAppCardColor.entries.forEachIndexed { idx, mode ->
                                    SegmentedButton(
                                        shape = SegmentedButtonDefaults.itemShape(
                                            index = idx,
                                            count = MorpheAppCardColor.entries.size
                                        ),
                                        onClick = { cardColorMode = mode },
                                        selected = cardColorMode == mode
                                    ) {
                                        Text(mode.label, style = MaterialTheme.typography.labelSmall)
                                    }
                                }
                            }
                        }
                    )
                }
            }

            // 4. MORPHE MANAGER: DISPLAY & SCALE
            item {
                JuneSettingsSection(title = "DISPLAY & SCALE (MORPHE MANAGER)") {
                    // App Language
                    JuneSettingsItem(
                        title = "App Language",
                        subtitle = "${selectedLanguage.flag} ${selectedLanguage.displayName}",
                        index = 0,
                        count = 3,
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Rounded.Language,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        trailingContent = {
                            MaterialChevron(tint = MaterialTheme.colorScheme.onSurfaceVariant)
                        },
                        onClick = { showLanguageDialog = true }
                    )

                    // UI Scale Setting
                    JuneSettingsItem(
                        title = "UI Scaling Factor",
                        subtitle = "Custom layout density (${(uiScale * 100).toInt()}%)",
                        index = 1,
                        count = 3,
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Rounded.Speed,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        content = {
                            Spacer(modifier = Modifier.height(8.dp))
                            MorpheUiScaleSetting(
                                currentScale = uiScale,
                                onApplyScale = { uiScale = it },
                                onResetScale = { uiScale = 1.0f }
                            )
                        }
                    )

                    // Launcher App Icon
                    JuneSettingsItem(
                        title = "Launcher App Icon",
                        subtitle = selectedAppIcon.label,
                        index = 2,
                        count = 3,
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Rounded.Apps,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        trailingContent = {
                            MaterialChevron(tint = MaterialTheme.colorScheme.onSurfaceVariant)
                        },
                        onClick = { showAppIconDialog = true }
                    )
                }
            }

            // 5. MORPHE MANAGER: SURFACE EFFECTS & BACKGROUND
            item {
                JuneSettingsSection(title = "SURFACE EFFECTS & BACKGROUND (MORPHE MANAGER)") {
                    // High-contrast Outlines
                    JuneSettingsItem(
                        title = "High-Contrast Outlines",
                        subtitle = "Draw explicit hairline borders around cards and surface containers",
                        index = 0,
                        count = 3,
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Rounded.BorderStyle,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        trailingContent = {
                            Switch(
                                checked = outlines,
                                onCheckedChange = { outlines = it },
                                thumbContent = if (outlines) {
                                    {
                                        Icon(
                                            imageVector = Icons.Rounded.Check,
                                            contentDescription = null,
                                            modifier = Modifier.size(SwitchDefaults.IconSize)
                                        )
                                    }
                                } else null
                            )
                        },
                        onClick = { outlines = !outlines }
                    )

                    // Frosted Blur
                    JuneSettingsItem(
                        title = "Frosted Background Blur",
                        subtitle = "Hardware Gaussian blur under modal sheets and floating bars",
                        index = 1,
                        count = 3,
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Rounded.BlurOn,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        trailingContent = {
                            Switch(
                                checked = blur,
                                onCheckedChange = { blur = it },
                                thumbContent = if (blur) {
                                    {
                                        Icon(
                                            imageVector = Icons.Rounded.Check,
                                            contentDescription = null,
                                            modifier = Modifier.size(SwitchDefaults.IconSize)
                                        )
                                    }
                                } else null
                            )
                        },
                        onClick = { blur = !blur }
                    )

                    // Animated Background Type
                    JuneSettingsItem(
                        title = "Dynamic Animated Background",
                        subtitle = "${backgroundType.label} • ${backgroundType.description}",
                        index = 2,
                        count = 3,
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Rounded.Wallpaper,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        trailingContent = {
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = MaterialTheme.colorScheme.primaryContainer
                            ) {
                                Text(
                                    text = "CYCLE",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                )
                            }
                        },
                        onClick = {
                            val allBg = MorpheBackgroundType.entries
                            val nextIdx = (allBg.indexOf(backgroundType) + 1) % allBg.size
                            backgroundType = allBg[nextIdx]
                        }
                    )
                }
            }

            // 6. MORPHE MANAGER: HOME SCREEN CUSTOMIZATION
            item {
                JuneSettingsSection(title = "HOME SCREEN CUSTOMIZATION (MORPHE MANAGER)") {
                    // Greeting Phrases
                    JuneSettingsItem(
                        title = "Greeting Phrases",
                        subtitle = "Show dynamic time-aware greeting banner on home screen",
                        index = 0,
                        count = 3,
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Rounded.ChatBubble,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        trailingContent = {
                            Switch(
                                checked = showGreetingPhrases,
                                onCheckedChange = { showGreetingPhrases = it },
                                thumbContent = if (showGreetingPhrases) {
                                    {
                                        Icon(
                                            imageVector = Icons.Rounded.Check,
                                            contentDescription = null,
                                            modifier = Modifier.size(SwitchDefaults.IconSize)
                                        )
                                    }
                                } else null
                            )
                        },
                        onClick = { showGreetingPhrases = !showGreetingPhrases }
                    )

                    // Repatch Notice
                    JuneSettingsItem(
                        title = "Repatch & Sync Notice",
                        subtitle = "Show notice when patch or module updates are available",
                        index = 1,
                        count = 3,
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Rounded.AutoFixHigh,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        trailingContent = {
                            Switch(
                                checked = showRepatchNotice,
                                onCheckedChange = { showRepatchNotice = it },
                                thumbContent = if (showRepatchNotice) {
                                    {
                                        Icon(
                                            imageVector = Icons.Rounded.Check,
                                            contentDescription = null,
                                            modifier = Modifier.size(SwitchDefaults.IconSize)
                                        )
                                    }
                                } else null
                            )
                        },
                        onClick = { showRepatchNotice = !showRepatchNotice }
                    )

                    // Companion Apps Card
                    JuneSettingsItem(
                        title = "Companion Apps & Modules Card",
                        subtitle = "Display ecosystem companion tools and module quick switcher",
                        index = 2,
                        count = 3,
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Rounded.Apps,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        trailingContent = {
                            Switch(
                                checked = showMoreAppsCard,
                                onCheckedChange = { showMoreAppsCard = it },
                                thumbContent = if (showMoreAppsCard) {
                                    {
                                        Icon(
                                            imageVector = Icons.Rounded.Check,
                                            contentDescription = null,
                                            modifier = Modifier.size(SwitchDefaults.IconSize)
                                        )
                                    }
                                } else null
                            )
                        },
                        onClick = { showMoreAppsCard = !showMoreAppsCard }
                    )
                }
            }

            // 7. CATEGORIES: Community Horizontal Chips Row
            item {
                Column {
                    Text(
                        text = "Acoustic Spaces & Categories",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 4.dp, bottom = 6.dp)
                    )

                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        MockDataProvider.categories.forEach { category ->
                            val isSelected = selectedCategory == category
                            FilterChip(
                                selected = isSelected,
                                onClick = { selectedCategory = category },
                                label = { Text(category) },
                                leadingIcon = if (isSelected) {
                                    {
                                        Icon(
                                            imageVector = Icons.Rounded.Check,
                                            contentDescription = null,
                                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                                        )
                                    }
                                } else null,
                                shape = RoundedCornerShape(8.dp) // Community rectilinear corners
                            )
                        }
                    }
                }
            }

            // 8. MEDIA ENGINE & PLAYBACK RATE (mpvEx & June Connected Section)
            item {
                JuneSettingsSection(title = "MEDIA ENGINE & PLAYBACK RATE (MPVEX)") {
                    // Playback Rate Row with Segmented Buttons
                    JuneSettingsItem(
                        title = "Playback Rate (libmpv)",
                        subtitle = "Dynamic variable rate stepping",
                        index = 0,
                        count = 2,
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Rounded.Speed,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        content = {
                            Spacer(modifier = Modifier.height(10.dp))
                            SingleChoiceSegmentedButtonRow(modifier = Modifier.fillMaxWidth()) {
                                speeds.forEachIndexed { index, speedLabel ->
                                    SegmentedButton(
                                        shape = SegmentedButtonDefaults.itemShape(
                                            index = index,
                                            count = speeds.size
                                        ),
                                        onClick = { selectedSpeedIndex = index },
                                        selected = selectedSpeedIndex == index
                                    ) {
                                        Text(speedLabel, style = MaterialTheme.typography.labelSmall)
                                    }
                                }
                            }
                        }
                    )

                    // Audio Stream Track Row with Dropdown
                    JuneSettingsItem(
                        title = "Audio Stream Track",
                        subtitle = selectedAudioTrack,
                        index = 1,
                        count = 2,
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Rounded.Movie,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        trailingContent = {
                            Box {
                                Surface(
                                    shape = RoundedCornerShape(12.dp),
                                    color = MaterialTheme.colorScheme.primaryContainer,
                                    modifier = Modifier.clickable { isAudioMenuOpen = true }
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "Tracks",
                                            style = MaterialTheme.typography.labelMedium,
                                            color = MaterialTheme.colorScheme.onPrimaryContainer
                                        )
                                        MaterialChevron(tint = MaterialTheme.colorScheme.onPrimaryContainer)
                                    }
                                }

                                DropdownMenu(
                                    expanded = isAudioMenuOpen,
                                    onDismissRequest = { isAudioMenuOpen = false }
                                ) {
                                    audioTracks.forEach { trackName ->
                                        DropdownMenuItem(
                                            text = { Text(trackName) },
                                            onClick = {
                                                selectedAudioTrack = trackName
                                                isAudioMenuOpen = false
                                            }
                                        )
                                    }
                                }
                            }
                        },
                        onClick = { isAudioMenuOpen = true }
                    )
                }
            }

            // 9. DSP TUNING SLIDERS (June Connected Section)
            item {
                JuneSettingsSection(title = "DSP HARMONICS & HAPTICS (COMMUNITY)") {
                    // Continuous Spatial Resonance Slider
                    JuneSettingsItem(
                        title = "DSP Harmonic Resonance",
                        subtitle = "Spatial audio reverberation (${(spatialResonance * 100).toInt()}%)",
                        index = 0,
                        count = 2,
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Rounded.GraphicEq,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        content = {
                            Spacer(modifier = Modifier.height(4.dp))
                            Slider(
                                value = spatialResonance,
                                onValueChange = { spatialResonance = it }
                            )
                        }
                    )

                    // Discrete Haptic Slider
                    JuneSettingsItem(
                        title = "Haptic Vibration Amplitude",
                        subtitle = "Tactile motor intensity (${(hapticIntensity * 100).toInt()}%)",
                        index = 1,
                        count = 2,
                        leadingContent = {
                            Icon(
                                imageVector = Icons.Rounded.Vibration,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(22.dp)
                            )
                        },
                        content = {
                            Spacer(modifier = Modifier.height(4.dp))
                            Slider(
                                value = hapticIntensity,
                                onValueChange = { hapticIntensity = it },
                                steps = 4
                            )
                        }
                    )
                }
            }

            // 10. STUDIO PRESETS (June Connected Section with Radio Buttons)
            item {
                JuneSettingsSection(title = "ACOUSTIC STUDIO PRESETS (JUNE LIST)") {
                    presets.forEachIndexed { index, preset ->
                        val isSelected = selectedPresetId == preset.id
                        JuneSettingsItem(
                            title = preset.name,
                            subtitle = preset.description,
                            index = index,
                            count = presets.size,
                            leadingContent = {
                                RadioButton(
                                    selected = isSelected,
                                    onClick = { selectedPresetId = preset.id }
                                )
                            },
                            onClick = { selectedPresetId = preset.id }
                        )
                    }
                }
            }

            // 11. SYSTEM MODULES CATALOG (Gboard-patches & Morphe Manager Style)
            item {
                val filteredModules = modules.filter {
                    searchQuery.isEmpty() ||
                            it.name.contains(searchQuery, ignoreCase = true) ||
                            it.description.contains(searchQuery, ignoreCase = true)
                }

                if (filteredModules.isNotEmpty()) {
                    JuneSettingsSection(title = "SYSTEM MODULES CATALOG (GBOARD & MORPHE)") {
                        filteredModules.forEachIndexed { index, module ->
                            val isChecked = moduleStates[module.id] ?: false
                            val iconVector = when (index % 3) {
                                0 -> Icons.Rounded.FormatColorFill
                                1 -> Icons.Rounded.Keyboard
                                else -> Icons.Rounded.Security
                            }

                            JuneSettingsItem(
                                title = module.name,
                                subtitle = "${module.version} • ${module.description}",
                                index = index,
                                count = filteredModules.size,
                                leadingContent = {
                                    Icon(
                                        imageVector = iconVector,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.secondary,
                                        modifier = Modifier.size(22.dp)
                                    )
                                },
                                trailingContent = {
                                    Switch(
                                        checked = isChecked,
                                        onCheckedChange = { checked ->
                                            moduleStates = moduleStates.toMutableMap().apply {
                                                put(module.id, checked)
                                            }
                                        },
                                        thumbContent = if (isChecked) {
                                            {
                                                Icon(
                                                    imageVector = Icons.Rounded.Check,
                                                    contentDescription = null,
                                                    modifier = Modifier.size(SwitchDefaults.IconSize)
                                                )
                                            }
                                        } else null
                                    )
                                },
                                onClick = {
                                    moduleStates = moduleStates.toMutableMap().apply {
                                        put(module.id, !isChecked)
                                    }
                                }
                            )
                        }
                    }
                }
            }

            // 12. DIAGNOSTICS & STATUS
            item {
                JuneSettingsSection(title = "ENGINE DIAGNOSTICS") {
                    JuneSettingsItem(
                        title = "Buffer Health (88%)",
                        subtitle = "Hardware libmpv pipe • Zero copy surface",
                        index = 0,
                        count = 1,
                        leadingContent = {
                            CircularProgressIndicator(
                                progress = { 0.88f },
                                modifier = Modifier.size(28.dp),
                                color = MaterialTheme.colorScheme.secondary
                            )
                        },
                        trailingContent = {
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = MaterialTheme.colorScheme.secondaryContainer
                            ) {
                                Text(
                                    text = "60 FPS",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    )
                }
            }

            // 13. ACTION SUITE (Community Button Row)
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Button(
                        onClick = { },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Render")
                    }

                    FilledTonalButton(
                        onClick = { },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Export")
                    }

                    OutlinedButton(
                        onClick = {
                            spatialResonance = 0.78f
                            hapticIntensity = 0.65f
                            selectedSpeedIndex = 1
                            themeMode = MorpheThemeMode.SYSTEM
                            colorStyle = MorpheColorStyle.MORPHE
                            selectedAccent = MorpheAccentColors.first()
                            cardColorMode = MorpheAppCardColor.DEFAULT
                            pureBlackTheme = false
                            colorAccents = true
                            uiScale = 1.0f
                            outlines = false
                            blur = true
                        },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Reset")
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(60.dp))
            }
        }
    }

    // Morphe Language Selection Dialog
    if (showLanguageDialog) {
        MorpheLanguageDialog(
            currentLanguage = selectedLanguage,
            onLanguageSelected = { selectedLanguage = it },
            onDismiss = { showLanguageDialog = false }
        )
    }

    // Morphe Launcher App Icon Dialog
    if (showAppIconDialog) {
        MorpheAppIconDialog(
            currentVariant = selectedAppIcon,
            onVariantSelected = { selectedAppIcon = it },
            onDismiss = { showAppIconDialog = false }
        )
    }
}
