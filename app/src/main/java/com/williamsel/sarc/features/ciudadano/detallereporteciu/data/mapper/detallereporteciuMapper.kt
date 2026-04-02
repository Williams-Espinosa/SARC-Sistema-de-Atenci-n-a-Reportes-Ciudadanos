package com.williamsel.sarc.detallereporteciu.data.mapper

import com.williamsel.sarc.detallereporteciu.data.models.DetallereporteciuDto
import com.williamsel.sarc.detallereporteciu.domain.entities.Detallereporteciu

fun DetallereporteciuDto.toDomain(): Detallereporteciu = Detallereporteciu(
    id          = id,
    titulo      = titulo,
    descripcion = descripcion,
    categoria   = categoria,
    iconoUrl    = iconoUrl,
    imagenUrl   = imagenUrl,
    estado      = estado,
    direccion   = direccion,
    latitud     = latitud,
    longitud    = longitud,
    fecha       = fecha
)
