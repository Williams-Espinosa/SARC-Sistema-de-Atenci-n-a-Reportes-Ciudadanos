package com.williamsel.sarc.features.publico.login.data.models

data class GoogleLoginRequestDto(
    val idToken: String
)
data class LoginDto(
    val id: Int,
    val correo: String,
    val token: String,
    val rol: String,
    val nombre: String? = null,
    val googleId: String? = null
)
