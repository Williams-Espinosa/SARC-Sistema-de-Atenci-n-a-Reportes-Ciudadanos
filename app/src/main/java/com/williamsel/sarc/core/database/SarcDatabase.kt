package com.williamsel.sarc.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.williamsel.sarc.database.dao.CatEstadoReporteDao
import com.williamsel.sarc.database.dao.CatIncidenciasDao
import com.williamsel.sarc.database.dao.ReporteDao
import com.williamsel.sarc.database.dao.RolDao
import com.williamsel.sarc.database.dao.UsuarioDao
import com.williamsel.sarc.database.entities.CatEstadoReporteEntity
import com.williamsel.sarc.database.entities.CatIncidenciasEntity
import com.williamsel.sarc.database.entities.ReporteEntity
import com.williamsel.sarc.database.entities.RolEntity
import com.williamsel.sarc.database.entities.UsuarioEntity

@Database(
    entities = [
        RolEntity::class,
        UsuarioEntity::class,
        CatIncidenciasEntity::class,
        CatEstadoReporteEntity::class,
        ReporteEntity::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class SarcDatabase : RoomDatabase() {
    abstract fun rolDao(): RolDao
    abstract fun usuarioDao(): UsuarioDao
    abstract fun catIncidenciasDao(): CatIncidenciasDao
    abstract fun catEstadoReporteDao(): CatEstadoReporteDao
    abstract fun reporteDao(): ReporteDao
}
