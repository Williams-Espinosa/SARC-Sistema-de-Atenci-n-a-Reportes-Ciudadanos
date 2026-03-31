package com.williamsel.sarc.features.publico.registro.data.models

data class RegistroRequestDto(
    val nombre: String,
    val correo: String,
    val contrasena: String
)

data class RegistroGoogleRequestDto(
    val idToken: String
)
data class RegistroDto(
    val id: Int,
    val nombre: String,
    val correo: String,
    val token: String,
    val rol: String,
    val googleId: String? = null
)
