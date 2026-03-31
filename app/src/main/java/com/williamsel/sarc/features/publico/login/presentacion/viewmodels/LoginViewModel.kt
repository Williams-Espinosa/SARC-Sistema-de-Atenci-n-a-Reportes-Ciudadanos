package com.williamsel.sarc.features.publico.login.presentacion.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.williamsel.sarc.core.session.SessionManager
import com.williamsel.sarc.features.publico.login.domain.usecases.LoginUseCase
import com.williamsel.sarc.features.publico.login.presentacion.screens.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val sessionManager: SessionManager
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    val state get() = _uiState.value

    fun onCorreoChange(value: String) {
        _uiState.update { it.copy(correo = value, errorMessage = null) }
    }

    fun onContrasenaChange(value: String) {
        _uiState.update { it.copy(contrasena = value, errorMessage = null) }
    }

    fun login() {
        val correo = _uiState.value.correo
        val contrasena = _uiState.value.contrasena

        if (correo.isBlank() || contrasena.isBlank()) {
            _uiState.update { it.copy(errorMessage = "Por favor completa todos los campos") }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            try {
                val resultado = loginUseCase(correo, contrasena)
                if (resultado != null) {
                    sessionManager.saveSession(token = resultado.token, rol = resultado.rol)
                    _uiState.update { it.copy(isLoading = false, isSuccess = true, rol = resultado.rol) }
                } else {
                    _uiState.update {
                        it.copy(isLoading = false, errorMessage = "Correo o contraseña incorrectos")
                    }
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(isLoading = false, errorMessage = "Error de conexión. Intenta de nuevo.")
                }
            }
        }
    }

    fun loginConGoogle() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            _uiState.update { it.copy(isLoading = false, errorMessage = "Google Sign-In próximamente") }
        }
    }

    fun resetState() {
        _uiState.update { LoginUiState() }
    }
}
