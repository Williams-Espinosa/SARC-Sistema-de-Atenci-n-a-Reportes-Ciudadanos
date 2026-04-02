package com.williamsel.sarc.detallereporteciu.data.datasource.api

import com.williamsel.sarc.detallereporteciu.data.models.DetallereporteciuDto
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceHolderdetallereporteciuApi {
    @GET("reportes/{id}")
    suspend fun getDetalleReporte(@Path("id") id: String): DetallereporteciuDto
}
