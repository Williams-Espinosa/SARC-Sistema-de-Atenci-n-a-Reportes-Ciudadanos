package com.williamsel.sarc.features.publico.login.data.mapper

import com.williamsel.sarc.features.publico.login.data.models.LoginDto
import com.williamsel.sarc.features.publico.login.domain.entities.Login

fun LoginDto.toDomain(): Login = Login(
    id       = id,
    correo   = correo,
    token    = token,
    rol      = rol,
    nombre   = nombre,
    googleId = googleId
)
