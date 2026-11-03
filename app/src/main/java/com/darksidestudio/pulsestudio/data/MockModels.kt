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
    val bitrate: String = "FLAC 24-bit / 96kHz",
    val waveform: List<Float> = listOf(0.2f, 0.5f, 0.8f, 0.4f, 0.9f, 0.6f, 0.3f, 0.7f, 1f, 0.4f)
)

data class StudioPreset(
    val id: String,
    val name: String,
    val description: String
)

data class SystemModule(
    val id: String,
    val name: String,
    val version: String,
    val description: String,
    val category: String,
    val isEnabled: Boolean = true,
    val isCore: Boolean = false
)

// Legacy compatibility aliases for existing references if any
typealias PatchModule = SystemModule
typealias SystemTweak = SystemModule
