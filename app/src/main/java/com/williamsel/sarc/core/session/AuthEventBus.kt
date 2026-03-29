package com.williamsel.sarc.core.session

import kotlinx.coroutines.flow.MutableSharedFlow


object AuthEventBus {
    val events = MutableSharedFlow<AuthEvent>(extraBufferCapacity = 1)

    sealed class AuthEvent {
        data object SessionExpired : AuthEvent()
    }

}

if (response.code == 401) {
    sessionManager.clearSession()
    AuthEventBus.events.tryEmit(AuthEventBus.AuthEvent.SessionExpired)
}