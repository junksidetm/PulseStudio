package com.darksidestudio.pulsestudio

import com.darksidestudio.pulsestudio.data.MockDataProvider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class MockDataProviderTest {

    @Test
    fun sampleTracks_areNotEmptyAndHaveValidDurations() {
        val tracks = MockDataProvider.sampleTracks
        assertTrue("Tracks should not be empty", tracks.isNotEmpty())
        tracks.forEach { track ->
            assertTrue("Track duration must be positive", track.durationSeconds > 0)
            assertFalse("Track title cannot be blank", track.title.isBlank())
            assertFalse("Track artist cannot be blank", track.artist.isBlank())
        }
    }

    @Test
    fun samplePatches_includeCoreAndExperimentalModules() {
        val patches = MockDataProvider.samplePatches
        assertTrue("Patches should not be empty", patches.isNotEmpty())
        assertTrue("Should include core modules", patches.any { it.isCore })
        assertTrue("Should include experimental modules", patches.any { it.isExperimental })
    }

    @Test
    fun sampleTweaks_categoriesAreDistinctAndValid() {
        val tweaks = MockDataProvider.sampleTweaks
        assertTrue("Tweaks should contain modules", tweaks.isNotEmpty())
        val categories = tweaks.map { it.category }.toSet()
        assertTrue("Categories should span multiple system domains", categories.size >= 3)
    }

    @Test
    fun sampleTimeline_containsEntriesWithMoods() {
        val timeline = MockDataProvider.sampleTimeline
        assertTrue("Timeline should contain cards", timeline.isNotEmpty())
        timeline.forEach { entry ->
            assertFalse("Mood should not be blank", entry.mood.isBlank())
            assertFalse("Tag should not be blank", entry.tag.isBlank())
        }
    }

    @Test
    fun studioPresets_areConfiguredWithDescriptions() {
        val presets = MockDataProvider.studioPresets
        assertEquals(4, presets.size)
        presets.forEach { preset ->
            assertFalse("Preset name cannot be blank", preset.name.isBlank())
            assertFalse("Preset description cannot be blank", preset.description.isBlank())
        }
    }
}
