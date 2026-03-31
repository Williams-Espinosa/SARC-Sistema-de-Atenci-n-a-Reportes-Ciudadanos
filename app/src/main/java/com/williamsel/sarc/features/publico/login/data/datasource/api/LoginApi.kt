package com.williamsel.sarc.features.publico.login.data.datasource.api

import com.williamsel.sarc.features.publico.login.data.models.LoginDto

interface LoginApi {
    suspend fun login(correo: String, contrasena: String): LoginDto
}
