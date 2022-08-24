package com.thegoodguys.pos.feature.info.app.presentation.destination.main

import com.thegoodguys.pos.core.compose.base.ViewEvent
import com.thegoodguys.pos.core.compose.base.ViewMapper
import com.thegoodguys.pos.core.compose.base.ViewSideEffect
import com.thegoodguys.pos.core.compose.base.ViewState

class MainContract {

    sealed class Event : ViewEvent {
        sealed class Navigation : Event() {
        }
    }

    class Mapper: ViewMapper

    data class State(
        val showOverlay: Boolean
    ) : ViewState

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            object Back : Navigation()
        }
    }

}