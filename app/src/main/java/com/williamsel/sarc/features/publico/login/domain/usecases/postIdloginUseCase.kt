package com.williamsel.sarc.login.domain.usecases

import com.williamsel.sarc.login.domain.entities.Login
import com.williamsel.sarc.login.domain.repositories.LoginRepository
import javax.inject.Inject

class postIdloginUseCase @Inject constructor(
    correo: String,
    private val repository: LoginRepository
) {
    suspend operator fun invoke(
        correo: String,
        contrasena: String
    ): Login? {
        return repository.login(correo, contrasena)
    }
}