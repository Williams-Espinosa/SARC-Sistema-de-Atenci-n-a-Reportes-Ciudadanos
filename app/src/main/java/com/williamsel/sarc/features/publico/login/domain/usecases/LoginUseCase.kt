package com.williamsel.sarc.features.publico.login.domain.usecases

import com.williamsel.sarc.features.publico.login.domain.entities.Login
import com.williamsel.sarc.features.publico.login.domain.repositories.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: LoginRepository
) {
    suspend operator fun invoke(correo: String, contrasena: String): Login? {
        return repository.login(correo, contrasena)
    }
}
