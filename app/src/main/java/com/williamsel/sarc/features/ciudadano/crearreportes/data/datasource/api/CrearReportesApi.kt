package com.williamsel.sarc.features.ciudadano.crearreportes.data.datasource.api

import com.williamsel.sarc.features.ciudadano.crearreportes.data.models.CategoriaDto
import com.williamsel.sarc.features.ciudadano.crearreportes.data.models.CrearReporteRequest
import com.williamsel.sarc.features.ciudadano.crearreportes.data.models.CrearReporteResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface CrearReportesApi {

    @POST("ciudadano/reportes")
    suspend fun crearReporte(
        @Body request: CrearReporteRequest
    ): CrearReporteResponse

    @Multipart
    @POST("ciudadano/reportes/{idReporte}/imagen")
    suspend fun subirImagen(
        @Path("idReporte")    idReporte: Int,
        @Part("id_reporte")   idReporteBody: RequestBody,
        @Part                 imagen: MultipartBody.Part
    ): CrearReporteResponse

    @GET("catalogo/incidencias")
    suspend fun getCategorias(): List<CategoriaDto>
}
