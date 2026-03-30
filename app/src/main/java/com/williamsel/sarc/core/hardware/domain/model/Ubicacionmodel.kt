package com.williamsel.sarc.hardware.domain.model

data class UbicacionModel(
    val latitud: Double,
    val longitud: Double,
    val direccion: String? = null
)