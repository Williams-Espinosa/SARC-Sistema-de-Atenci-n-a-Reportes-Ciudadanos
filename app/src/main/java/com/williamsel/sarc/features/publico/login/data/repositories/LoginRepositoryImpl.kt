package com.williamsel.sarc.features.publico.login.data.repositories

import com.williamsel.sarc.features.publico.login.data.datasource.api.LoginApi
import com.williamsel.sarc.features.publico.login.data.mapper.toDomain
import com.williamsel.sarc.features.publico.login.domain.entities.Login
import com.williamsel.sarc.features.publico.login.domain.repositories.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val api: LoginApi
) : LoginRepository {

    override suspend fun login(correo: String, contrasena: String): Login? {
        return try {
            val response = api.login(correo, contrasena)
            response.toDomain()
        } catch (e: Exception) {
            null
        }
    }
}
