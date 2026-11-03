package com.darksidestudio.pulsestudio.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.EditNote
import androidx.compose.material.icons.rounded.Extension
import androidx.compose.material.icons.rounded.Fingerprint
import androidx.compose.material.icons.rounded.FormatColorFill
import androidx.compose.material.icons.rounded.Keyboard
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Movie
import androidx.compose.material.icons.rounded.MusicNote
import androidx.compose.material.icons.rounded.Pause
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Security
import androidx.compose.material.icons.rounded.Speed
import androidx.compose.material.icons.rounded.TextFields
import androidx.compose.material.icons.rounded.Vibration
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

/**
 * "The Other's Way" Screen:
 * Synthesizes authentic Material 3 Community design choices directly from:
 * - DenserMeerkat/June: Connected settings list architecture (JuneConnectedList & JuneConnectedItem)
 *   with position-aware adaptive corners (28dp/8dp), interactive spring tactile morphing, and pill search bar.
 * - junksidetm/Gboard-patches: Vector chevrons, hairline dividers, M3 switches with checkmark thumbs.
 * - marlboro-advance/mpvEx: SingleChoiceSegmentedButtonRow rate selector and audio track dropdown.
 * - cromaguy/Rhythm: Docked mini-player bar with live progress indicator and queue play/pause.
 * - morpheapp/microg-RE: System status cards and service availability indicators.
 * - MorpheApp/morphe-manager: Module catalog with version badges and inclusion toggles.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OthersWayScreen(
    onNavigateBack: () -> Unit
) {
    // Search query state (June style search)
    var searchQuery by remember { mutableStateOf("") }

    // mpvEx Playback speed state
    val playbackSpeeds = listOf("0.5x", "1.0x", "1.25x", "1.5x", "2.0x")
    var selectedSpeedIndex by remember { mutableIntStateOf(1) }

    // mpvEx Audio track dropdown menu
    var isAudioMenuExpanded by remember { mutableStateOf(false) }
    var selectedAudioTrack by remember { mutableStateOf("English [5.1 Surround]") }
    val audioTracks = listOf("English [5.1 Surround]", "Japanese [Original FLAC]", "Director's Commentary [Stereo]")

    // Gboard-patches switch states
    val tweaks = remember { MockDataProvider.sampleTweaks }
    var tweakStates by remember { mutableStateOf(tweaks.associate { it.id to it.isEnabled }) }

    // Morphe Manager patch switches
    val patches = remember { MockDataProvider.samplePatches }
    var patchStates by remember { mutableStateOf(patches.associate { it.id to it.isEnabled }) }

    // June-specific Journaling preference toggles
    var alwaysOpenNewNote by remember { mutableStateOf(true) }
    var markdownEditorEnabled by remember { mutableStateOf(true) }
    var appLockBiometric by remember { mutableStateOf(false) }

    // Rhythm mini-player state
    var isMiniPlayerPlaying by remember { mutableStateOf(true) }

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
                                text = "Midnight Horizon",
                                style = MaterialTheme.typography.titleMedium.copy(fontSize = 14.sp),
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "Aetheria • Rhythm MiniPlayer",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }

                        IconButton(onClick = { isMiniPlayerPlaying = !isMiniPlayerPlaying }) {
                            Icon(
                                imageVector = if (isMiniPlayerPlaying) Icons.Rounded.Pause else Icons.Rounded.PlayArrow,
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
                            text = "Search settings, patches, audio...",
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

            // microg-RE Inspired Status Banner
            item {
                JuneSettingsSection {
                    JuneSettingsItem(
                        title = "Core Environment Active",
                        subtitle = "microG Core • Gboard Engine • mpvEx Pipeline Ready",
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

            // Section 1: Gboard Patches (Connected Settings List - June Architecture)
            item {
                val filteredTweaks = tweaks.filter {
                    searchQuery.isEmpty() ||
                            it.title.contains(searchQuery, ignoreCase = true) ||
                            it.summary.contains(searchQuery, ignoreCase = true)
                }

                if (filteredTweaks.isNotEmpty()) {
                    JuneSettingsSection(title = "GBOARD PATCHES (COMMUNITY TOGGLES)") {
                        filteredTweaks.forEachIndexed { index, tweak ->
                            val isChecked = tweakStates[tweak.id] ?: false
                            val iconVector = when (index % 3) {
                                0 -> Icons.Rounded.FormatColorFill
                                1 -> Icons.Rounded.Keyboard
                                else -> Icons.Rounded.TextFields
                            }

                            JuneSettingsItem(
                                title = tweak.title,
                                subtitle = tweak.summary,
                                index = index,
                                count = filteredTweaks.size,
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
                                            tweakStates = tweakStates.toMutableMap().apply {
                                                put(tweak.id, checked)
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
                                    tweakStates = tweakStates.toMutableMap().apply {
                                        put(tweak.id, !isChecked)
                                    }
                                }
                            )
                        }
                    }
                }
            }

            // Section 2: mpvEx Media Controls (Connected List with Embedded Controls)
            item {
                if (searchQuery.isEmpty() || "media playback mpvex audio stream rate".contains(searchQuery, ignoreCase = true)) {
                    JuneSettingsSection(title = "MEDIA ENGINE & PLAYBACK RATE (MPVEX)") {
                        // Rate Selector connected item
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
                                    playbackSpeeds.forEachIndexed { index, speedLabel ->
                                        SegmentedButton(
                                            shape = SegmentedButtonDefaults.itemShape(
                                                index = index,
                                                count = playbackSpeeds.size
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

                        // Audio Track Selector connected item with Dropdown
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
                                        modifier = Modifier.clickable { isAudioMenuExpanded = true }
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
                                        expanded = isAudioMenuExpanded,
                                        onDismissRequest = { isAudioMenuExpanded = false }
                                    ) {
                                        audioTracks.forEach { track ->
                                            DropdownMenuItem(
                                                text = { Text(track) },
                                                onClick = {
                                                    selectedAudioTrack = track
                                                    isAudioMenuExpanded = false
                                                }
                                            )
                                        }
                                    }
                                }
                            },
                            onClick = { isAudioMenuExpanded = true }
                        )
                    }
                }
            }

            // Section 3: Morphe Manager Catalog (Connected Settings List - June Architecture)
            item {
                val filteredPatches = patches.filter {
                    searchQuery.isEmpty() ||
                            it.name.contains(searchQuery, ignoreCase = true) ||
                            it.description.contains(searchQuery, ignoreCase = true)
                }

                if (filteredPatches.isNotEmpty()) {
                    JuneSettingsSection(title = "MORPHE MANAGER PATCH CATALOG") {
                        filteredPatches.forEachIndexed { index, patch ->
                            val isChecked = patchStates[patch.id] ?: false
                            val iconVector = when (index % 3) {
                                0 -> Icons.Rounded.Extension
                                1 -> Icons.Rounded.Security
                                else -> Icons.Rounded.Vibration
                            }

                            JuneSettingsItem(
                                title = patch.name,
                                subtitle = "${patch.version} • ${patch.description}",
                                index = index,
                                count = filteredPatches.size,
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
                                            patchStates = patchStates.toMutableMap().apply {
                                                put(patch.id, checked)
                                            }
                                        }
                                    )
                                },
                                onClick = {
                                    patchStates = patchStates.toMutableMap().apply {
                                        put(patch.id, !isChecked)
                                    }
                                }
                            )
                        }
                    }
                }
            }

            // Section 4: June Journaling & Privacy Preferences (Direct June Architecture)
            item {
                if (searchQuery.isEmpty() || "june note editor markdown biometric vault lock".contains(searchQuery, ignoreCase = true)) {
                    JuneSettingsSection(title = "JUNE JOURNALING & PRIVACY") {
                        // Always Open New Note
                        JuneSettingsItem(
                            title = "Always Open New Note",
                            subtitle = "Instantly open the journaling composer upon app launch",
                            index = 0,
                            count = 3,
                            leadingContent = {
                                Icon(
                                    imageVector = Icons.Rounded.EditNote,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.secondary,
                                    modifier = Modifier.size(22.dp)
                                )
                            },
                            trailingContent = {
                                Switch(
                                    checked = alwaysOpenNewNote,
                                    onCheckedChange = { alwaysOpenNewNote = it }
                                )
                            },
                            onClick = { alwaysOpenNewNote = !alwaysOpenNewNote }
                        )

                        // Markdown Rich Text Editor
                        JuneSettingsItem(
                            title = "Markdown Editor",
                            subtitle = if (markdownEditorEnabled) "Rich markdown formatting enabled" else "Plain text mode",
                            index = 1,
                            count = 3,
                            leadingContent = {
                                Icon(
                                    imageVector = Icons.Rounded.TextFields,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.secondary,
                                    modifier = Modifier.size(22.dp)
                                )
                            },
                            trailingContent = {
                                Switch(
                                    checked = markdownEditorEnabled,
                                    onCheckedChange = { markdownEditorEnabled = it }
                                )
                            },
                            onClick = { markdownEditorEnabled = !markdownEditorEnabled }
                        )

                        // Biometric & Vault Lock
                        JuneSettingsItem(
                            title = "Vault & App Lock",
                            subtitle = if (appLockBiometric) "Biometric fingerprint authentication required" else "Unrestricted local access",
                            index = 2,
                            count = 3,
                            leadingContent = {
                                Icon(
                                    imageVector = if (appLockBiometric) Icons.Rounded.Fingerprint else Icons.Rounded.Lock,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.secondary,
                                    modifier = Modifier.size(22.dp)
                                )
                            },
                            trailingContent = {
                                Switch(
                                    checked = appLockBiometric,
                                    onCheckedChange = { appLockBiometric = it }
                                )
                            },
                            onClick = { appLockBiometric = !appLockBiometric }
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}
