package com.thegoodguys.pos.feature.info.app.presentation.activity

import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.thegoodguys.pos.core.compose.base.ComposeActivityBase
import com.thegoodguys.pos.core.domain.model.AppBuildConfig
import com.thegoodguys.pos.feature.info.app.presentation.destination.app.App
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComposeActivityBase() {

    @Inject
    lateinit var appBuildConfig: AppBuildConfig

    override fun getIsEdgeToEdge(): Boolean {
       return true
    }

    override fun onSessionEnd() {

    }

    override fun onShowTimeoutDialog() {

    }

    override fun setup() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        // Update the system bars to be translucent

        //todo ( Remove: Required for dummy to device settings to work )
        connectionLiveData.updateConnection()

        setContent {

            val systemUiController = rememberSystemUiController()
            val useDarkIcons = MaterialTheme.colors.isLight

            SideEffect {
                systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = useDarkIcons)
            }

            App(appBuildConfig = appBuildConfig)
        }
    }


}
