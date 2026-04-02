package com.williamsel.sarc.features.ciudadano.mapaciu.data.mapper

import com.williamsel.sarc.features.ciudadano.mapaciu.data.models.ReporteMapa
import com.williamsel.sarc.features.ciudadano.mapaciu.domain.entities.ReporteMapaEntity

fun ReporteMapa.toDomain(): ReporteMapaEntity = ReporteMapaEntity(
    idReporte    = idReporte,
    nombre       = nombre,
    descripcion  = descripcion,
    latitud      = latitud,
    longitud     = longitud,
    idIncidencia = idIncidencia,
    idEstado     = idEstado,
    fechaReporte = fechaReporte
)
