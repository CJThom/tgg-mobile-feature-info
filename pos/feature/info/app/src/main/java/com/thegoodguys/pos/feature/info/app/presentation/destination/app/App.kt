package com.thegoodguys.pos.feature.info.app.presentation.destination.app

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.thegoodguys.pos.core.compose.theme.TGGTheme
import com.thegoodguys.pos.core.domain.model.AppBuildConfig

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun App(
    appBuildConfig: AppBuildConfig
) {
    TGGTheme {
        AppNavGraph(
            appBuildConfig = appBuildConfig,
            modifier = Modifier
        )
    }
}

