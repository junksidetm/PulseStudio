package com.darksidestudio.pulsestudio.data

object MockDataProvider {

    val sampleTracks = listOf(
        MediaTrack(
            id = "trk-1",
            title = "Midnight Horizon",
            artist = "Aetheria",
            album = "Digital Echoes",
            durationText = "3:42",
            durationSeconds = 222,
            category = "Synthwave",
            isFavorite = true,
            bitrate = "FLAC 24-bit"
        ),
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

    val samplePatches = listOf(
        PatchModule(
            id = "patch-emoji",
            name = "Custom 3D Emoji Font",
            version = "v4.1.1",
            description = "Load TrueType / OpenType 3D emoji fonts dynamically without root.",
            targetApp = "com.google.android.inputmethod.latin",
            isEnabled = true,
            isCore = true
        ),
        PatchModule(
            id = "patch-frosted",
            name = "Seamless Frosted Glass",
            version = "v2.0.4",
            description = "Edge-to-edge keyboard blur extending seamlessly into bottom navigation bar.",
            targetApp = "com.google.android.inputmethod.latin",
            isEnabled = true,
            isCore = false
        ),
        PatchModule(
            id = "patch-haptics",
            name = "Keypress Vibration Intensity",
            version = "v1.1.0",
            description = "Controls amplitude strength instead of millisecond duration.",
            targetApp = "com.google.android.inputmethod.latin",
            isEnabled = false,
            isExperimental = true
        ),
        PatchModule(
            id = "patch-speed",
            name = "Hardware Video Decoders",
            version = "v3.2.0",
            description = "Direct libmpv hardware video pipe with zero copy surface rendering.",
            targetApp = "com.marlboro.mpvex",
            isEnabled = true,
            isCore = true
        ),
        PatchModule(
            id = "patch-microg",
            name = "SafetyNet Attestation Spoof",
            version = "v0.3.1",
            description = "Redirect GmsCore attestation callbacks through unprivileged Binder.",
            targetApp = "com.google.android.gms",
            isEnabled = true,
            isCore = true
        )
    )

    val sampleTimeline = listOf(
        TimelineCard(
            id = "tm-1",
            title = "Architecting Expressive Components",
            snippet = "Refactored the segmented button hierarchy and replaced flat tabs with dynamic spring-loaded chips.",
            mood = "Focused",
            dateText = "Today • 2:15 PM",
            tag = "Design"
        ),
        TimelineCard(
            id = "tm-2",
            title = "Zero-OOM Canvas Rendering",
            snippet = "Eliminated Dalvik heap allocations on continuous audio waveforms using pre-allocated Path buffers.",
            mood = "Energetic",
            dateText = "Yesterday • 8:40 PM",
            tag = "Performance"
        ),
        TimelineCard(
            id = "tm-3",
            title = "FOSS Design Convergence",
            snippet = "Studied June and Rhythm layout systems to harmonize density with modern Material 3 Expressive guidelines.",
            mood = "Reflective",
            dateText = "Oct 30 • 11:10 AM",
            tag = "Research"
        )
    )

    val sampleTweaks = listOf(
        SystemTweak(
            id = "tw-1",
            title = "High Refresh Rate Lock (120Hz)",
            summary = "Forces PeakRefreshRate to match panel limit regardless of battery saver.",
            isEnabled = true,
            category = "Display"
        ),
        SystemTweak(
            id = "tw-2",
            title = "Spacebar Cursor Trackpad Mode",
            summary = "Persistent trackpad navigation across reboots and Phenotype updates.",
            isEnabled = true,
            category = "Input"
        ),
        SystemTweak(
            id = "tw-3",
            title = "Universal Language Models",
            summary = "Allowlist dictionary prediction engines across all global locales.",
            isEnabled = true,
            category = "AI Tools"
        ),
        SystemTweak(
            id = "tw-4",
            title = "Aggressive Doze Exemption",
            summary = "Bypass thermal power throttling for background audio synchronization.",
            isEnabled = false,
            category = "Battery"
        )
    )
}
