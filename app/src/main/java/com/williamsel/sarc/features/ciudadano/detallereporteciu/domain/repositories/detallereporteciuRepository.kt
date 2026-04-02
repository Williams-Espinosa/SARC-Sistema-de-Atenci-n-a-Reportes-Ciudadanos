package com.williamsel.sarc.detallereporteciu.domain.repositories

import com.williamsel.sarc.detallereporteciu.domain.entities.Detallereporteciu

interface DetallereporteciuRepository {
    suspend fun getDetalleReporte(id: String): Result<Detallereporteciu>
}
