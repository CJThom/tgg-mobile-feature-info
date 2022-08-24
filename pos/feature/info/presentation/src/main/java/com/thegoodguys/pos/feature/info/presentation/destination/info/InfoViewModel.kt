package com.thegoodguys.pos.feature.info.presentation.destination.info

import androidx.lifecycle.SavedStateHandle
import com.thegoodguys.pos.core.compose.base.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class InfoViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : MVIViewModel<
        InfoScreenContract.Event,
        InfoScreenContract.State,
        InfoScreenContract.Effect,
        InfoScreenContract.Mapper>() {

    override fun setMapper(): InfoScreenContract.Mapper {
        return InfoScreenContract.Mapper()
    }

    override fun setInitialState(): InfoScreenContract.State {
        return InfoScreenContract.State()
    }


    override fun handleEvents(event: InfoScreenContract.Event) {
        when (event) {
            is InfoScreenContract.Event.Navigation.Back -> {
                setEffect { InfoScreenContract.Effect.Navigation.Back }
            }
        }
    }

}



