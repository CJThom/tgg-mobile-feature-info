package com.thegoodguys.pos.feature.info.app.presentation.destination.app

import com.thegoodguys.pos.core.compose.base.ViewEvent
import com.thegoodguys.pos.core.compose.base.ViewMapper
import com.thegoodguys.pos.core.compose.base.ViewSideEffect
import com.thegoodguys.pos.core.compose.base.ViewState


class AppContract {

    sealed class Event : ViewEvent {
        sealed class Navigation : Event() {
            object CloseApplication : Navigation()
            object Back : Navigation()
            object ToLoginScreen : Navigation()
            object ToMainScreen : Navigation()
        }
    }

    class Mapper: ViewMapper

    class State() : ViewState

    sealed class Effect : ViewSideEffect {
        sealed class Navigation : Effect() {
            object CloseApplication : Navigation()
            object Back : Navigation()
            object ToLoginScreen : Navigation()
            object ToMainScreen : Navigation()
        }
    }

}