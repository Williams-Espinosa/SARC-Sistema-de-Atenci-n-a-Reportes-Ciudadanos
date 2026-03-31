package com.williamsel.sarc.login.data.mapper

import com.williamsel.sarc.login.data.models.LoginDto
import com.williamsel.sarc.login.domain.entities.Login

fun LoginDto.toDomain(): Login {
    return Login(
        id = id,
        correo = correo,
        token = token
    )
}