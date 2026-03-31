package com.williamsel.sarc.features.publico.registro.di

import com.williamsel.sarc.features.publico.registro.data.repositories.RegistroRepositoryImpl
import com.williamsel.sarc.features.publico.registro.domain.repositories.RegistroRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RegistroModule {

    @Binds
    @Singleton
    abstract fun bindRegistroRepository(
        impl: RegistroRepositoryImpl
    ): RegistroRepository
}
