package com.thegoodguys.pos.feature.info.presentation.destination.info

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.thegoodguys.pos.core.compose.theme.TGGTheme
import com.thegoodguys.pos.core.compose.theme.normal
import com.thegoodguys.pos.core.compose.widget.OverlineItem
import com.thegoodguys.pos.core.compose.widget.TopAppBarTitle
import com.thegoodguys.pos.core.domain.model.AppBuildConfig
import com.thegoodguys.pos.core.domain.model.Flavor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun InfoScreen(
    appBuildConfig: AppBuildConfig,
    // state: InfoScreenContract.State,
    effectFlow: Flow<InfoScreenContract.Effect>?,
    onEventSent: (event: InfoScreenContract.Event) -> Unit,
    onNavigationRequested: (navigationEffect: InfoScreenContract.Effect.Navigation) -> Unit
) {

    BackHandler {
        onEventSent(InfoScreenContract.Event.Navigation.Back)
    }

    LaunchedEffect(true) {
        effectFlow?.onEach { effect ->
            when (effect) {
                is InfoScreenContract.Effect.Navigation.Back -> onNavigationRequested(effect)
            }
        }?.collect()
    }

    Scaffold(
        modifier = Modifier,
        backgroundColor = MaterialTheme.colors.surface,
        topBar = {
            TopAppBar(
                title = {
                    TopAppBarTitle(title = "App Information")
                },
                elevation = 0.dp,
                backgroundColor = MaterialTheme.colors.surface,
                modifier = Modifier.statusBarsPadding(),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onEventSent(InfoScreenContract.Event.Navigation.Back)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        },
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(contentPadding)
                .padding(normal.at100.dp),
            verticalArrangement = Arrangement.spacedBy(normal.at100.dp)
        ) {
            OverlineItem(
                label = "Environment",
                value = appBuildConfig.environmentName.uppercase(),
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            )
            OverlineItem(
                label = "Version",
                value = appBuildConfig.versionName,
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            )
        }
    }

}

class AppBuildConfigProvider : PreviewParameterProvider<AppBuildConfig> {
    override val values = sequenceOf(
        AppBuildConfig(
            appName = "Info",
            versionName = "1.0.0",
            environmentName = "PRD",
            basePOSURL_1 = "",
            basePOSURL_2 = "",
            baseMWURL_1 = "",
            basicUsername = "",
            basicPassword = "",
            flavor = Flavor.PRD,
            posCertificateResourceId = 0,
            mwCertificateResourceId = 0
        ),
        AppBuildConfig(
            appName = "Info",
            versionName = "1.3.1-alpha22",
            environmentName = "OFFLINE",
            basePOSURL_1 = "",
            basePOSURL_2 = "",
            baseMWURL_1 = "",
            basicUsername = "",
            basicPassword = "",
            flavor = Flavor.OFFLINE,
            posCertificateResourceId = 0,
            mwCertificateResourceId = 0
        )
    )
}

@Preview
@Composable
private fun InfoScreenPreview(@PreviewParameter(AppBuildConfigProvider::class) appBuildConfig: AppBuildConfig) {

    TGGTheme {
        InfoScreen(
            appBuildConfig = appBuildConfig,
            effectFlow = null,
            onEventSent = {},
            onNavigationRequested = {}
        )
    }

}