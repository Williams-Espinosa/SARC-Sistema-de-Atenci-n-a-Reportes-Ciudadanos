package com.williamsel.sarc.features.ciudadano.mapaciu.di

import com.williamsel.sarc.features.ciudadano.mapaciu.data.repositories.MapaCiudadanoRepositoryImpl
import com.williamsel.sarc.features.ciudadano.mapaciu.domain.repositories.MapaCiudadanoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MapaCiudadanoModule {

    @Binds
    @Singleton
    abstract fun bindMapaCiudadanoRepository(
        impl: MapaCiudadanoRepositoryImpl
    ): MapaCiudadanoRepository
}
