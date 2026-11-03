package com.darksidestudio.pulsestudio.data

/**
 * Unified Single Source of Truth for Pulse Studio.
 * Both "The AI Way" and "The Other's Way" consume this exact identical dataset,
 * allowing an authentic 1:1 side-by-side shootout between AI-crafted Material 3 Expressive
 * and real-world Open Source Community Material 3 implementations.
 */
object MockDataProvider {

    val activeTrack = MediaTrack(
        id = "trk-1",
        title = "Midnight Horizon",
        artist = "Aetheria",
        album = "Digital Echoes",
        durationText = "3:42",
        durationSeconds = 222,
        category = "Synthwave",
        isFavorite = true,
        bitrate = "FLAC 24-bit / 96kHz"
    )

    val sampleTracks = listOf(
        activeTrack,
        MediaTrack(
            id = "trk-2",
            title = "Neon District Drift",
            artist = "Kuroshio",
            album = "Tokyo Cyberpunk",
            durationText = "4:15",
            durationSeconds = 255,
            category = "Ambient",
            isFavorite = false,
            bitrate = "320 kbps"
        ),
        MediaTrack(
            id = "trk-3",
            title = "Solar Wind Cascade",
            artist = "Orbital Array",
            album = "Starlight Voyager",
            durationText = "5:08",
            durationSeconds = 308,
            category = "Electronic",
            isFavorite = true,
            bitrate = "FLAC 96kHz"
        ),
        MediaTrack(
            id = "trk-4",
            title = "Velvet Rain",
            artist = "Luna Vane",
            album = "Quiet Hours",
            durationText = "2:58",
            durationSeconds = 178,
            category = "Lo-Fi",
            isFavorite = false,
            bitrate = "256 kbps"
        )
    )

    val playbackSpeeds = listOf("0.5x", "1.0x", "1.25x", "1.5x", "2.0x")

    val audioTracks = listOf(
        "English [5.1 Surround]",
        "Japanese [Original FLAC]",
        "Director's Commentary [Stereo]"
    )

    val categories = listOf("All", "Synthwave", "Ambient", "Electronic", "Lo-Fi")

    val studioPresets = listOf(
        StudioPreset(
            id = "pre-1",
            name = "Studio Balanced",
            description = "Neutral frequency response calibrated for reference studio monitors."
        ),
        StudioPreset(
            id = "pre-2",
            name = "Bass Resonance",
            description = "Sub-bass harmonic boost with dynamic analog warmth."
        ),
        StudioPreset(
            id = "pre-3",
            name = "Vocal Clarity",
            description = "Mid-range enhancement highlighting vocal presence and dialogue."
        ),
        StudioPreset(
            id = "pre-4",
            name = "Atmospheric 3D",
            description = "Expansive binaural stereo widening with spatial reverberation."
        )
    )

    val studioModules = listOf(
        SystemModule(
            id = "mod-emoji",
            name = "Dynamic Color Theming",
            version = "v4.1.1",
            description = "Harmonize canvas palette with Material You dynamic wallpaper scheme.",
            category = "Theming",
            isEnabled = true,
            isCore = true
        ),
        SystemModule(
            id = "mod-speed",
            name = "Hardware Video Decoders",
            version = "v3.2.0",
            description = "Zero-copy surface rendering via direct libmpv hardware pipeline.",
            category = "Engine",
            isEnabled = true,
            isCore = true
        ),
        SystemModule(
            id = "mod-haptics",
            name = "Haptic Feedback Engine",
            version = "v1.1.0",
            description = "Controls amplitude vibration intensity instead of millisecond duration.",
            category = "Haptics",
            isEnabled = false,
            isCore = false
        ),
        SystemModule(
            id = "mod-microg",
            name = "SafetyNet Attestation Spoof",
            version = "v0.3.1",
            description = "Redirect GmsCore attestation callbacks through unprivileged Binder.",
            category = "Security",
            isEnabled = true,
            isCore = true
        ),
        SystemModule(
            id = "mod-frosted",
            name = "Seamless Frosted Glass",
            version = "v2.0.4",
            description = "Edge-to-edge translucent blur extending into bottom navigation bar.",
            category = "Theming",
            isEnabled = true,
            isCore = false
        )
    )

    // Aliases for compatibility
    val samplePatches = studioModules
    val sampleTweaks = studioModules
}
