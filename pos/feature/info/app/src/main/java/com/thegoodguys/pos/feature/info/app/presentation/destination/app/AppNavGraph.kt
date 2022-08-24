package com.thegoodguys.pos.feature.info.app.presentation.destination.app

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.thegoodguys.pos.core.domain.model.AppBuildConfig
import com.thegoodguys.pos.feature.info.app.presentation.destination.main.MainScreen
import com.thegoodguys.pos.feature.info.app.presentation.destination.main.MainViewModel
import com.thegoodguys.pos.feature.info.presentation.destination.InfoScreenDestination


@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun AppNavGraph(
    appBuildConfig: AppBuildConfig,
    modifier: Modifier = Modifier,
    startDestination: String = "info"
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

//        loginNavGraph(
//            appBuildConfig = appBuildConfig,
//            navController = navController,
//            endDestination = "main",
//            route = startDestination
//        )

        composable(route = "info") {
            InfoScreenDestination(
                appBuildConfig = appBuildConfig,
                navController = navController
            )
        }

        composable(route = "main") {
            MainScreenDestination()
        }

    }
}

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun MainScreenDestination() {

    val mainViewModel: MainViewModel = hiltViewModel()
    val state = mainViewModel.viewState.value
    val coroutineScope = rememberCoroutineScope()

    MainScreen(
        state = state,
        effectFlow = mainViewModel.effect,
        coroutineScope = coroutineScope,
        onEventSent = { event -> mainViewModel.setEvent(event) },
        onNavigationRequested = { effect ->

        }
    )
}










