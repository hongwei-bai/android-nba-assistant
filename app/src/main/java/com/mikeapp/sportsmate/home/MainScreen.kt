package com.mikeapp.sportsmate.home

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mikeapp.sportsmate.dashboard.Dashboard
import com.mikeapp.sportsmate.news.News
import com.mikeapp.sportsmate.season.Season
import com.mikeapp.sportsmate.settings.Settings

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    var size by remember { mutableStateOf(IntSize.Zero) }

    Scaffold(bottomBar = { BottomNavBar(navController) }) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .onSizeChanged { size = it }) {
            MainNavCompose(navController, size)
        }
    }
}


@Composable
fun MainNavCompose(navController: NavHostController, size: IntSize) {
    val springSpec = spring<IntOffset>(dampingRatio = Spring.DampingRatioMediumBouncy)

    NavHost(navController = navController, startDestination = "dashboard") {
        composable(
            route = "dashboard",
            enterTransition = { slideInHorizontally(initialOffsetX = { size.width }, animationSpec = springSpec) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -size.width }, animationSpec = springSpec) }
        ) {
            Dashboard()
        }
        composable(
            route = "season",
            enterTransition = { slideInHorizontally(initialOffsetX = { size.width }, animationSpec = springSpec) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -size.width }, animationSpec = springSpec) }
        ) {
            Season()
        }
        composable(
            route = "news",
            enterTransition = { slideInHorizontally(initialOffsetX = { size.width }, animationSpec = springSpec) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -size.width }, animationSpec = springSpec) }
        ) {
            News()
        }
        composable(
            route = "settings",
            enterTransition = { slideInHorizontally(initialOffsetX = { size.width }, animationSpec = springSpec) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -size.width }, animationSpec = springSpec) }
        ) {
            Settings()
        }
    }
}