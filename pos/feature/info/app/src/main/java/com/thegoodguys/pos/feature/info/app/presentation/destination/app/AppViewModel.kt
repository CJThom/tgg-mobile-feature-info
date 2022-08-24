package com.thegoodguys.pos.feature.info.app.presentation.destination.app


import androidx.lifecycle.SavedStateHandle
import com.thegoodguys.pos.core.compose.base.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : MVIViewModel<
        AppContract.Event,
        AppContract.State,
        AppContract.Effect,
        AppContract.Mapper>() {

    override fun setMapper(): AppContract.Mapper {
        return AppContract.Mapper()
    }

    override fun setInitialState(): AppContract.State {
        return AppContract.State()
    }

    override fun handleEvents(event: AppContract.Event) {
        when (event) {
            is AppContract.Event.Navigation -> when (event) {
                is AppContract.Event.Navigation.CloseApplication -> {
                    setEffect { AppContract.Effect.Navigation.CloseApplication }
                }
                is AppContract.Event.Navigation.Back -> {
                    setEffect { AppContract.Effect.Navigation.Back }
                }
                is AppContract.Event.Navigation.ToLoginScreen -> {
                    setEffect { AppContract.Effect.Navigation.ToLoginScreen }
                }
                is AppContract.Event.Navigation.ToMainScreen -> {
                    setEffect { AppContract.Effect.Navigation.ToMainScreen }
                }
            }
        }
    }
}