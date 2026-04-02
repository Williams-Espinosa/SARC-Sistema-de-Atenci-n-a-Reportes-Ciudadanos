package com.williamsel.sarc.detallereporteciu.domain.usecases

import com.williamsel.sarc.detallereporteciu.domain.entities.Detallereporteciu
import com.williamsel.sarc.detallereporteciu.domain.repositories.DetallereporteciuRepository
import javax.inject.Inject

class GetIddetallereporteciuUseCase @Inject constructor(
    private val repository: DetallereporteciuRepository
) {
    suspend operator fun invoke(id: String): Result<Detallereporteciu> =
        repository.getDetalleReporte(id)
}
