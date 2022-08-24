package com.thegoodguys.pos.feature.info.presentation.destination

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.thegoodguys.pos.core.domain.model.AppBuildConfig
import com.thegoodguys.pos.feature.info.presentation.destination.info.InfoScreen
import com.thegoodguys.pos.feature.info.presentation.destination.info.InfoScreenContract
import com.thegoodguys.pos.feature.info.presentation.destination.info.InfoViewModel


@Composable
fun InfoScreenDestination(
    infoViewModel: InfoViewModel = hiltViewModel(),
    appBuildConfig: AppBuildConfig,
    navController: NavHostController
) {

    InfoScreen(
        appBuildConfig = appBuildConfig,
       // state = infoViewModel.viewState.value,
        effectFlow = infoViewModel.effect,
        onEventSent = { event -> infoViewModel.setEvent(event) },
        onNavigationRequested = { effect ->
            when (effect) {
                is InfoScreenContract.Effect.Navigation.Back -> navController.popBackStack()
            }
        }
    )
}
