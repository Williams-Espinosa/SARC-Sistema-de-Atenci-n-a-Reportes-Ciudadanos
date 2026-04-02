package com.williamsel.sarc.detallereporteciu.data.repositories

import com.williamsel.sarc.detallereporteciu.data.datasource.api.JsonPlaceHolderdetallereporteciuApi
import com.williamsel.sarc.detallereporteciu.data.mapper.toDomain
import com.williamsel.sarc.detallereporteciu.domain.entities.Detallereporteciu
import com.williamsel.sarc.detallereporteciu.domain.repositories.DetallereporteciuRepository
import javax.inject.Inject

class DetallereporteciuImpl @Inject constructor(
    private val api: JsonPlaceHolderdetallereporteciuApi
) : DetallereporteciuRepository {

    override suspend fun getDetalleReporte(id: String): Result<Detallereporteciu> =
        runCatching { api.getDetalleReporte(id).toDomain() }
}
