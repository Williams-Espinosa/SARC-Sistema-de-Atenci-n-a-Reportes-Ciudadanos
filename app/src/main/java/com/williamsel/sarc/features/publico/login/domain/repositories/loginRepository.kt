package com.williamsel.sarc.login.domain.repositories

import com.williamsel.sarc.login.domain.entities.Login

interface LoginRepository {
    suspend fun login(correo: String, contrasena: String): Login?
}