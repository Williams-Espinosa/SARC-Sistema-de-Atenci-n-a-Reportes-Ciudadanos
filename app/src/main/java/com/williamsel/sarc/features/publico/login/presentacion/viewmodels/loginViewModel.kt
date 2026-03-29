package com.williamsel.sarc.login.presentacion.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.williamsel.sarc.login.domain.usecases.GetIdloginUseCase
import com.williamsel.sarc.login.presentacion.LoginUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getIdloginUseCase: GetIdloginUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<LoginUIState>(LoginUIState.Idle)
    val uiState: StateFlow<LoginUIState> = _uiState

    var correo by mutableStateOf("")
        private set

    var contrasena by mutableStateOf("")
        private set

    fun onCorreoChange(value: String) {
        correo = value
    }

    fun onContrasenaChange(value: String) {
        contrasena = value
    }

    fun login() {
        if (correo.isBlank() || contrasena.isBlank()) {
            _uiState.value = LoginUIState.Error("Por favor completa todos los campos")
            return
        }
        viewModelScope.launch {
            _uiState.value = LoginUIState.Loading
            try {
                val resultado = getIdloginUseCase(correo, contrasena)
                if (resultado != null) {
                    _uiState.value = LoginUIState.Success
                } else {
                    _uiState.value = LoginUIState.Error("Correo o contraseña incorrectos")
                }
            } catch (e: Exception) {
                _uiState.value = LoginUIState.Error("Error de conexión. Intenta de nuevo.")
            }
        }
    }

    fun loginConGoogle() {
        viewModelScope.launch {
            _uiState.value = LoginUIState.Loading
            _uiState.value = LoginUIState.Error("Google Sign-In próximamente")
        }
    }

    fun resetState() {
        _uiState.value = LoginUIState.Idle
    }
}