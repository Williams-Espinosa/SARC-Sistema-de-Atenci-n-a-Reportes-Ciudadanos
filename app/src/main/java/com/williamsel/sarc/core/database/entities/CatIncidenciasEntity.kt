package com.williamsel.sarc.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cat_incidencia")
data class CatIncidenciasEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_incidencia")
    val idIncidencia: Int = 0,

    @ColumnInfo(name = "nombre")
    val nombre: String
)
