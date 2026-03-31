package com.williamsel.sarc.features.publico.login.data.models

data class LoginDto(
    val id: Int,
    val correo: String,
    val token: String,
    val rol: String
)
