package com.thegoodguys.pos.feature.info.app.presentation.destination.main

import androidx.lifecycle.SavedStateHandle
import com.thegoodguys.pos.core.compose.base.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : MVIViewModel<
        MainContract.Event,
        MainContract.State,
        MainContract.Effect,
        MainContract.Mapper>() {

    override fun setMapper(): MainContract.Mapper {
        return MainContract.Mapper()
    }

    override fun setInitialState(): MainContract.State {
        return MainContract.State(
            showOverlay = false
        )
    }

    override fun handleEvents(event: MainContract.Event) {

    }

}
