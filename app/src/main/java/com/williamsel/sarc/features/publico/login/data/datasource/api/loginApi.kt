package com.williamsel.sarc.login.data.datasource.api

import com.williamsel.sarc.login.data.models.LoginDto

interface loginApi {

    suspend fun login(
        correo: String,
        contrasena: String
    ): LoginDto
}