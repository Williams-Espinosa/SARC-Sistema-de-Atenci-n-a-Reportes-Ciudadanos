package com.williamsel.sarc.hardware.domain

interface CameraManager {
    suspend fun tomarFoto(): ByteArray?
    fun tienePermisoCamera(): Boolean
}