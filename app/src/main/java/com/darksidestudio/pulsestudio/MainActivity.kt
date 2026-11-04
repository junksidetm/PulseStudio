package com.darksidestudio.pulsestudio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.darksidestudio.pulsestudio.ui.screens.AiWayScreen
import com.darksidestudio.pulsestudio.ui.screens.DualComparisonScreen
import com.darksidestudio.pulsestudio.ui.screens.HomeScreen
import com.darksidestudio.pulsestudio.ui.screens.OthersWayScreen
import com.darksidestudio.pulsestudio.ui.theme.PulseStudioTheme
import com.darksidestudio.pulsestudio.ui.viewmodel.AppDestination
import com.darksidestudio.pulsestudio.ui.viewmodel.PulseStudioViewModel

/**
 * Main Activity for Pulse Studio.
 * Utilizes ViewModel with StateFlow and collectAsStateWithLifecycle to ensure
 * zero state loss across configuration changes, dark mode toggles, and multi-window resizing.
 */
class MainActivity : ComponentActivity() {

    private val viewModel: PulseStudioViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

            PulseStudioTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    PulseStudioApp(
                        currentDestination = uiState.currentDestination,
                        splitRatio = uiState.splitRatio,
                        onNavigateTo = { viewModel.navigateTo(it) },
                        onNavigateBack = { viewModel.navigateBack() },
                        onSplitRatioChange = { viewModel.setSplitRatio(it) }
                    )
                }
            }
        }
    }
}

@Composable
fun PulseStudioApp(
    currentDestination: AppDestination,
    splitRatio: Float,
    onNavigateTo: (AppDestination) -> Unit,
    onNavigateBack: () -> Unit,
    onSplitRatioChange: (Float) -> Unit
) {
    BackHandler(enabled = currentDestination != AppDestination.Home) {
        onNavigateBack()
    }

    AnimatedContent(
        targetState = currentDestination,
        transitionSpec = {
            fadeIn(animationSpec = tween(280)) togetherWith fadeOut(animationSpec = tween(240))
        },
        label = "navigation_crossfade"
    ) { destination ->
        when (destination) {
            AppDestination.Home -> {
                HomeScreen(
                    onSelectAiWay = { onNavigateTo(AppDestination.AiWay) },
                    onSelectOthersWay = { onNavigateTo(AppDestination.OthersWay) },
                    onSelectDualInspector = { onNavigateTo(AppDestination.DualInspector) }
                )
            }
            AppDestination.AiWay -> {
                AiWayScreen(
                    onNavigateBack = onNavigateBack
                )
            }
            AppDestination.OthersWay -> {
                OthersWayScreen(
                    onNavigateBack = onNavigateBack
                )
            }
            AppDestination.DualInspector -> {
                DualComparisonScreen(
                    splitRatio = splitRatio,
                    onSplitChange = onSplitRatioChange,
                    onSelectAiWay = { onNavigateTo(AppDestination.AiWay) },
                    onSelectOthersWay = { onNavigateTo(AppDestination.OthersWay) },
                    onNavigateBack = onNavigateBack
                )
            }
        }
    }
}
