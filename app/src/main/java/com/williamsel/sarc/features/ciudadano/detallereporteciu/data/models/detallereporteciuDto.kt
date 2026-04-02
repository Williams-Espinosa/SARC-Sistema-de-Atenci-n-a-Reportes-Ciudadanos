package com.williamsel.sarc.detallereporteciu.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetallereporteciuDto(
    @SerialName("id")           val id: String,
    @SerialName("titulo")       val titulo: String,
    @SerialName("descripcion")  val descripcion: String,
    @SerialName("categoria")    val categoria: String,
    @SerialName("icono_url")    val iconoUrl: String?   = null,
    @SerialName("imagen_url")   val imagenUrl: String?  = null,
    @SerialName("estado")       val estado: String,
    @SerialName("direccion")    val direccion: String,
    @SerialName("latitud")      val latitud: Double,
    @SerialName("longitud")     val longitud: Double,
    @SerialName("fecha")        val fecha: String
)
