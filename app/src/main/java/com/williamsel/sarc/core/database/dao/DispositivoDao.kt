package com.williamsel.sarc.core.database.dao

import androidx.room.*
import com.williamsel.labkeep.core.database.entities.DispositivoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DispositivoDao {
    @Query("SELECT * FROM dispositivos WHERE operacion != 'eliminar' OR operacion = ''")
    fun getAll(): Flow<List<DispositivoEntity>>

    @Query("SELECT * FROM dispositivos WHERE id = :id LIMIT 1")
    suspend fun getById(id: String): DispositivoEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dispositivo: DispositivoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(dispositivos: List<DispositivoEntity>)

    @Update
    suspend fun update(dispositivo: DispositivoEntity)

    @Query("DELETE FROM dispositivos WHERE id = :id")
    suspend fun deleteById(id: String)
    @Query("SELECT * FROM dispositivos WHERE pendienteSync = 1")
    suspend fun getPendientes(): List<DispositivoEntity>
}
