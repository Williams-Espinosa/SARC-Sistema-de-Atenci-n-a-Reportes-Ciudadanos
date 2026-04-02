package com.williamsel.sarc.features.ciudadano.mapaciu.data.models

import androidx.compose.ui.graphics.Color

/** DTO del reporte mínimo necesario para pintar el marcador en el mapa */
data class ReporteMapa(
    val idReporte:    Int,
    val nombre:       String,
    val descripcion:  String,
    val latitud:      Double,
    val longitud:     Double,
    val idIncidencia: Int?,
    val idEstado:     Int?,
    val fechaReporte: Long?
)

/** Categorías de incidencia con color para el marcador */
enum class FiltroCategoriaDto(val id: Int?, val label: String) {
    TODOS(null, "Todos"),
    BACHE(1, "Bache"),
    BASURA(2, "Basura"),
    ALUMBRADO(3, "Alumbrado"),
    OTRO(4, "Otro")
}

/** Estados del reporte con color para el marcador */
enum class FiltroEstadoDto(val id: Int?, val label: String) {
    TODOS(null, "Todos"),
    PENDIENTE(1, "Pendiente"),
    EN_PROCESO(2, "En proceso"),
    RESUELTO(3, "Resuelto"),
    RECHAZADO(4, "Rechazado")
}
