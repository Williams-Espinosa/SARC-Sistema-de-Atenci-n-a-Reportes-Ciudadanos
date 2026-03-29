package com.williamsel.labkeep.core.database

import android.content.Context
import androidx.room.Room
import com.williamsel.labkeep.core.database.dao.DispositivoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): SarcDatabase {
        return Room.databaseBuilder(
            context,
            SarcDatabase::class.java,
            "sarc_db"
        ).build()
    }
    @Provides
    @Singleton
    fun provideDispositivoDao(db: SarcDatabase): DispositivoDao {
        return db.dispositivoDao()
    }
}