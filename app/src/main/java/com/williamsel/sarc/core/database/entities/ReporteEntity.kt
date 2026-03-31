package com.williamsel.sarc.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "reporte",
    foreignKeys = [
        ForeignKey(
            entity = UsuarioEntity::class,
            parentColumns = ["id_usuario"],
            childColumns = ["id_usuario"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CatIncidenciasEntity::class,
            parentColumns = ["id_incidencia"],
            childColumns = ["id_incidencia"],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = CatEstadoReporteEntity::class,
            parentColumns = ["id_estado"],
            childColumns = ["id_estado"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [
        Index("id_usuario"),
        Index("id_incidencia"),
        Index("id_estado")
    ]
)
data class ReporteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_reporte")
    val idReporte: Int = 0,

    /** Título/nombre del reporte (VARCHAR 250) */
    @ColumnInfo(name = "nombre")
    val nombre: String,

    @ColumnInfo(name = "descripcion")
    val descripcion: String,

    /**
     * URL o ruta de la imagen almacenada (VARCHAR 500).
     * En Room se guarda como String, no como ByteArray.
     */
    @ColumnInfo(name = "imagen")
    val imagen: String? = null,

    /** DECIMAL(10,8) — latitud de la incidencia */
    @ColumnInfo(name = "latitud")
    val latitud: Double,

    /** DECIMAL(11,8) — longitud de la incidencia */
    @ColumnInfo(name = "longitud")
    val longitud: Double,

    /**
     * Timestamp en milisegundos (equivalente a CURRENT_TIMESTAMP en Postgres).
     * Usar System.currentTimeMillis() al insertar si es null.
     */
    @ColumnInfo(name = "fecha_reporte")
    val fechaReporte: Long? = System.currentTimeMillis(),

    @ColumnInfo(name = "id_usuario")
    val idUsuario: Int? = null,

    @ColumnInfo(name = "id_incidencia")
    val idIncidencia: Int? = null,

    /** Default 1 — estado inicial del reporte */
    @ColumnInfo(name = "id_estado")
    val idEstado: Int? = 1
)
