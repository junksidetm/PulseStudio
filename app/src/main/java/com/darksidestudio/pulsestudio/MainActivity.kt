package com.darksidestudio.pulsestudio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.darksidestudio.pulsestudio.ui.screens.AiWayScreen
import com.darksidestudio.pulsestudio.ui.screens.HomeScreen
import com.darksidestudio.pulsestudio.ui.screens.OthersWayScreen
import com.darksidestudio.pulsestudio.ui.theme.PulseStudioTheme

enum class AppDestination {
    Home,
    AiWay,
    OthersWay
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            PulseStudioTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    PulseStudioApp()
                }
            }
        }
    }
}

@Composable
fun PulseStudioApp() {
    var currentDestination by remember { mutableStateOf(AppDestination.Home) }

    BackHandler(enabled = currentDestination != AppDestination.Home) {
        currentDestination = AppDestination.Home
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
                    onSelectAiWay = { currentDestination = AppDestination.AiWay },
                    onSelectOthersWay = { currentDestination = AppDestination.OthersWay }
                )
            }
            AppDestination.AiWay -> {
                AiWayScreen(
                    onNavigateBack = { currentDestination = AppDestination.Home }
                )
            }
            AppDestination.OthersWay -> {
                OthersWayScreen(
                    onNavigateBack = { currentDestination = AppDestination.Home }
                )
            }
        }
    }
}
