package com.williamsel.sarc.features.ciudadano.crearreportes.data.repositories

import com.williamsel.sarc.database.dao.CatIncidenciasDao
import com.williamsel.sarc.database.dao.ReporteDao
import com.williamsel.sarc.database.entities.ReporteEntity
import com.williamsel.sarc.features.ciudadano.crearreportes.data.datasource.api.CrearReportesApi
import com.williamsel.sarc.features.ciudadano.crearreportes.data.mapper.toDomain
import com.williamsel.sarc.features.ciudadano.crearreportes.data.mapper.toRequest
import com.williamsel.sarc.features.ciudadano.crearreportes.domain.entities.CategoriaIncidencia
import com.williamsel.sarc.features.ciudadano.crearreportes.domain.entities.NuevoReporte
import com.williamsel.sarc.features.ciudadano.crearreportes.domain.repositories.CrearReportesRepository
import kotlinx.coroutines.flow.first
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject

class CrearReportesRepositoryImpl @Inject constructor(
    private val api: CrearReportesApi,
    private val reporteDao: ReporteDao,
    private val catIncidenciasDao: CatIncidenciasDao
) : CrearReportesRepository {

    override suspend fun enviarReporte(idUsuario: Int, reporte: NuevoReporte): Result<Int> {
        return try {
            val localId = reporteDao.insert(
                ReporteEntity(
                    nombre      = reporte.titulo,
                    descripcion = reporte.descripcion,
                    ubicacion   = reporte.ubicacion,
                    imagen      = reporte.imagenBytes,
                    idUsuario   = idUsuario,
                    idInsidencias = reporte.idIncidencia,
                    idEstado    = 1,
                    fechaReporte = System.currentTimeMillis()
                )
            )

            val response = api.crearReporte(reporte.toRequest(idUsuario))

            reporte.imagenBytes?.let { bytes ->
                val imagePart = MultipartBody.Part.createFormData(
                    "imagen",
                    "reporte_${response.idReportes}.jpg",
                    bytes.toRequestBody("image/jpeg".toMediaTypeOrNull())
                )
                val idPart = response.idReportes.toString()
                    .toRequestBody("text/plain".toMediaTypeOrNull())
                api.subirImagen(response.idReportes, idPart, imagePart)
            }

            Result.success(response.idReportes)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getCategorias(): List<CategoriaIncidencia> {
        return try {
            api.getCategorias().map { it.toDomain() }
        } catch (e: Exception) {
            catIncidenciasDao.getAll().first().map { entity ->
                CategoriaIncidencia(
                    id     = entity.idInsidencias,
                    nombre = entity.nombre,
                    emoji  = when (entity.nombre.lowercase()) {
                        "bache"     -> "🚧"
                        "basura"    -> "🗑️"
                        "alumbrado" -> "💡"
                        else        -> "📋"
                    }
                )
            }
        }
    }
}
