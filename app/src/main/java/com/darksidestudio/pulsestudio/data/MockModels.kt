package com.darksidestudio.pulsestudio.data

data class MediaTrack(
    val id: String,
    val title: String,
    val artist: String,
    val album: String,
    val durationText: String,
    val durationSeconds: Int,
    val category: String,
    val isFavorite: Boolean = false,
    val bitrate: String = "320 kbps",
    val waveform: List<Float> = listOf(0.2f, 0.5f, 0.8f, 0.4f, 0.9f, 0.6f, 0.3f, 0.7f, 1f, 0.4f)
)

data class PatchModule(
    val id: String,
    val name: String,
    val version: String,
    val description: String,
    val targetApp: String,
    val isEnabled: Boolean,
    val isCore: Boolean = false,
    val isExperimental: Boolean = false
)

data class TimelineCard(
    val id: String,
    val title: String,
    val snippet: String,
    val mood: String,
    val dateText: String,
    val tag: String
)

data class SystemTweak(
    val id: String,
    val title: String,
    val summary: String,
    val isEnabled: Boolean,
    val category: String
)
