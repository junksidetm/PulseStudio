package com.darksidestudio.pulsestudio

import com.darksidestudio.pulsestudio.ui.viewmodel.AppDestination
import com.darksidestudio.pulsestudio.ui.viewmodel.PulseStudioViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

/**
 * Unit tests verifying PulseStudioViewModel state transitions.
 */
class PulseStudioViewModelTest {

    private lateinit var viewModel: PulseStudioViewModel

    @Before
    fun setUp() {
        viewModel = PulseStudioViewModel()
    }

    @Test
    fun initialState_isCorrect() {
        val state = viewModel.uiState.value
        assertEquals(AppDestination.Home, state.currentDestination)
        assertEquals(0.5f, state.splitRatio, 0.01f)
        assertTrue(state.isPlaybackActive)
        assertEquals("1.0x", state.playbackSpeed)
        assertEquals("Studio Balanced", state.activePreset)
    }

    @Test
    fun navigateTo_updatesDestination() {
        viewModel.navigateTo(AppDestination.AiWay)
        assertEquals(AppDestination.AiWay, viewModel.uiState.value.currentDestination)

        viewModel.navigateTo(AppDestination.DualInspector)
        assertEquals(AppDestination.DualInspector, viewModel.uiState.value.currentDestination)

        viewModel.navigateBack()
        assertEquals(AppDestination.Home, viewModel.uiState.value.currentDestination)
    }

    @Test
    fun setSplitRatio_clampsToValidBounds() {
        viewModel.setSplitRatio(0.75f)
        assertEquals(0.75f, viewModel.uiState.value.splitRatio, 0.01f)

        // Lower clamp
        viewModel.setSplitRatio(0.02f)
        assertEquals(0.1f, viewModel.uiState.value.splitRatio, 0.01f)

        // Upper clamp
        viewModel.setSplitRatio(0.99f)
        assertEquals(0.9f, viewModel.uiState.value.splitRatio, 0.01f)
    }

    @Test
    fun togglePlayback_flipsFlag() {
        assertTrue(viewModel.uiState.value.isPlaybackActive)
        viewModel.togglePlayback()
        assertFalse(viewModel.uiState.value.isPlaybackActive)
    }
}
