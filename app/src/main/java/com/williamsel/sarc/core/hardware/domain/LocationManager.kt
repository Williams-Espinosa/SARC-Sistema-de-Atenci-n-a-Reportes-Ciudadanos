package com.williamsel.sarc.hardware.domain

import com.williamsel.sarc.hardware.domain.model.UbicacionModel

interface LocationManager {
    suspend fun obtenerUbicacion(): UbicacionModel?
    fun tienePermisoUbicacion(): Boolean
}