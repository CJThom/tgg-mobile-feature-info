package com.thegoodguys.pos.feature.info.presentation.destination.info

import com.thegoodguys.pos.core.compose.base.ViewEvent
import com.thegoodguys.pos.core.compose.base.ViewMapper
import com.thegoodguys.pos.core.compose.base.ViewSideEffect
import com.thegoodguys.pos.core.compose.base.ViewState


class InfoScreenContract {
    sealed class Event : ViewEvent {

        sealed class Navigation : Event() {
            object Back : Navigation()
        }
    }

    class Mapper() : ViewMapper

    class State() : ViewState

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            object Back : Navigation()
        }
    }
}