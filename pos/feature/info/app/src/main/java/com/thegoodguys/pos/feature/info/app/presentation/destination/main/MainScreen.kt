package com.thegoodguys.pos.feature.info.app.presentation.destination.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@Composable
fun MainScreen(
    state: MainContract.State,
    effectFlow: Flow<MainContract.Effect>?,
    coroutineScope: CoroutineScope,
    onEventSent: (event: MainContract.Event) -> Unit,
    onNavigationRequested: (event: MainContract.Effect.Navigation) -> Unit
) {

    val navController = rememberNavController()

    LaunchedEffect(true) {
        effectFlow?.onEach { effect ->
            when (effect) {
                is MainContract.Effect.Navigation -> when (effect) {
                    MainContract.Effect.Navigation.Back -> navController.popBackStack()
                }
            }
        }?.collect()
    }

//    Scaffold(
//        modifier = Modifier.padding(bottom = large.at150.dp)
//    ) {
//
//    }

}



