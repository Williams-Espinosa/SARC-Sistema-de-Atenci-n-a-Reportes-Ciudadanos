package com.williamsel.sarc.core.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dispositivos")
data class DispositivoEntity(
    @PrimaryKey val id: String,
    val nombre: String,
    val marca: String,
    val modelo: String,
    val numeroSerie: String,
    val ubicacion: String,
    val pendienteSync: Boolean = false,
    val operacion: String = ""
)
