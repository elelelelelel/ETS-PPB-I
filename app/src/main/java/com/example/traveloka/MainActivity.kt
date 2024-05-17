package com.example.traveloka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.traveloka.screen.NavGraphs
import com.example.traveloka.screen.destinations.BlankScreenDestination
import com.example.traveloka.screen.destinations.HomeScreenDestination
import com.example.traveloka.ui.navigation.BottomNavigationBar
import com.example.traveloka.ui.theme.RedesignTravelokaTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.rememberNavHostEngine

@OptIn(ExperimentalAnimationApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RedesignTravelokaTheme(darkTheme = false) {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberAnimatedNavController()
                    val navHostEngine = rememberNavHostEngine()

                    val newsBackStackEntry by navController.currentBackStackEntryAsState()
                    val route = newsBackStackEntry?.destination?.route

                    BottomNavigationBar(
                        navController = navController,
                        showBottomBar = route in listOf(
                            HomeScreenDestination.route,
                            BlankScreenDestination.route,
                        )
                    ) { paddingValues ->
                        Box(
                            modifier = Modifier.padding(paddingValues)
                        ) {
                            DestinationsNavHost(
                                navGraph = NavGraphs.root,
                                navController = navController,
                                engine = navHostEngine
                            )
                        }
                    }
                }
            }
        }
    }
}
