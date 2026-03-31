package com.williamsel.sarc.login.domain.entities

data class Login(
    val id: Int,
    val correo: String,
    val token: String
)