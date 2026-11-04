package com.darksidestudio.pulsestudio.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Navigation destinations for the Pulse Studio design shootout.
 */
enum class AppDestination {
    Home,
    AiWay,
    OthersWay,
    DualInspector
}

data class PulseStudioUiState(
    val currentDestination: AppDestination = AppDestination.Home,
    val splitRatio: Float = 0.5f, // For A/B wipe comparison: 0.0 (all Others) to 1.0 (all AI)
    val isPlaybackActive: Boolean = true,
    val playbackSpeed: String = "1.0x",
    val activePreset: String = "Studio Balanced"
)

/**
 * Lifecycle-aware ViewModel governing navigation state and A/B benchmark parameters.
 * Guarantees state survival across device orientation, theme toggles, and split-screen mode.
 */
class PulseStudioViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PulseStudioUiState())
    val uiState: StateFlow<PulseStudioUiState> = _uiState.asStateFlow()

    fun navigateTo(destination: AppDestination) {
        _uiState.update { it.copy(currentDestination = destination) }
    }

    fun navigateBack() {
        _uiState.update { it.copy(currentDestination = AppDestination.Home) }
    }

    fun setSplitRatio(ratio: Float) {
        _uiState.update { it.copy(splitRatio = ratio.coerceIn(0.1f, 0.9f)) }
    }

    fun togglePlayback() {
        _uiState.update { it.copy(isPlaybackActive = !it.isPlaybackActive) }
    }

    fun setPlaybackSpeed(speed: String) {
        _uiState.update { it.copy(playbackSpeed = speed) }
    }

    fun setActivePreset(preset: String) {
        _uiState.update { it.copy(activePreset = preset) }
    }
}
