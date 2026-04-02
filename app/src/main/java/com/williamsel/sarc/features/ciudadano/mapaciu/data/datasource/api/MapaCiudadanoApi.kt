package com.williamsel.sarc.features.ciudadano.mapaciu.data.datasource.api

import com.williamsel.sarc.features.ciudadano.mapaciu.data.models.ReporteMapaDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MapaCiudadanoApi {

    /** Todos los reportes con coordenadas para pintar marcadores */
    @GET("reportes/mapa")
    suspend fun getReportes(): List<ReporteMapaDto>

    /** Filtrados por categoría y/o estado */
    @GET("reportes/mapa")
    suspend fun getReportesFiltrados(
        @Query("id_incidencia") idIncidencia: Int? = null,
        @Query("id_estado")     idEstado:     Int? = null
    ): List<ReporteMapaDto>
}
