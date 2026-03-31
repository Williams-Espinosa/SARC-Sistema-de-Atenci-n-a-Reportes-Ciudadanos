package com.williamsel.sarc.login.data.repositories

import com.williamsel.sarc.login.data.datasource.api.loginApi
import com.williamsel.sarc.login.data.mapper.toDomain
import com.williamsel.sarc.login.domain.entities.Login
import com.williamsel.sarc.login.domain.repositories.LoginRepository
import javax.inject.Inject

class loginImpl @Inject constructor(
    private val api: loginApi
) : LoginRepository {

    override suspend fun login(
        correo: String,
        contrasena: String
    ): Login? {
        return try {
            val response = api.login(correo, contrasena)
            response.toDomain()
        } catch (e: Exception) {
            null
        }
    }
}