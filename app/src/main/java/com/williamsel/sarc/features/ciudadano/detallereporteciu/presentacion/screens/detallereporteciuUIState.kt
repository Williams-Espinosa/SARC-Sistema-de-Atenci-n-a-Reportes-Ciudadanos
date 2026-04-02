package com.williamsel.sarc.detallereporteciu.presentacion.screens

import com.williamsel.sarc.detallereporteciu.domain.entities.Detallereporteciu

sealed class DetallereporteciuUIState {
    object Loading : DetallereporteciuUIState()
    data class Success(val reporte: Detallereporteciu) : DetallereporteciuUIState()
    data class Error(val mensaje: String) : DetallereporteciuUIState()
}
