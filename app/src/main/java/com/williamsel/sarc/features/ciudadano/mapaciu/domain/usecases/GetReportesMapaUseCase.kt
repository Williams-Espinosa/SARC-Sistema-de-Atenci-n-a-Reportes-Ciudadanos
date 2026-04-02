package com.williamsel.sarc.features.ciudadano.mapaciu.domain.usecases

import com.williamsel.sarc.features.ciudadano.mapaciu.domain.entities.ReporteMapaEntity
import com.williamsel.sarc.features.ciudadano.mapaciu.domain.repositories.MapaCiudadanoRepository
import javax.inject.Inject

class GetReportesMapaUseCase @Inject constructor(
    private val repository: MapaCiudadanoRepository
) {
    suspend operator fun invoke(
        idIncidencia: Int? = null,
        idEstado:     Int? = null
    ): List<ReporteMapaEntity> = repository.getReportesMapa(idIncidencia, idEstado)
}
