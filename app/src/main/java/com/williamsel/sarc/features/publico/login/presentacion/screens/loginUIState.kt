package com.williamsel.sarc.login.presentacion

sealed class LoginUIState {
    object Idle    : LoginUIState()
    object Loading : LoginUIState()
    object Success : LoginUIState()
    data class Error(val mensaje: String) : LoginUIState()
}