package com.williamsel.sarc.features.ciudadano.mapaciu.data.models

/** Reporte tal como lo devuelve el backend para el mapa */
data class ReporteMapaDto(
    val idReporte:    Int,
    val nombre:       String,
    val descripcion:  String,
    val latitud:      Double,
    val longitud:     Double,
    val idIncidencia: Int?,
    val idEstado:     Int?,
    val fechaReporte: Long?
)

/** Opciones de filtro de categoría — deben coincidir con cat_incidencia */
enum class FiltroCategoriaDto(val id: Int?, val label: String) {
    TODOS(null, "Todos"),
    BACHE(1, "Bache"),
    BASURA(2, "Basura"),
    ALUMBRADO(3, "Alumbrado"),
    OTRO(4, "Otro")
}

/** Opciones de filtro de estado — deben coincidir con cat_estado_reporte */
enum class FiltroEstadoDto(val id: Int?, val label: String) {
    TODOS(null, "Todos"),
    PENDIENTE(1, "Pendiente"),
    EN_PROCESO(2, "En proceso"),
    RESUELTO(3, "Resuelto")
}
