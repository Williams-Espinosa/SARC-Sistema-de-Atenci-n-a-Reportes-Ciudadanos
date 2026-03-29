package com.williamsel.sarc.core.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [DispositivoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class SarcDatabase : RoomDatabase() {
    abstract fun cualDAO(): //cual
}
