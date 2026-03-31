package com.williamsel.sarc.hardware.di

import com.williamsel.sarc.hardware.data.AndroidCameraManager
import com.williamsel.sarc.hardware.data.AndroidLocationManager
import com.williamsel.sarc.hardware.domain.CameraManager
import com.williamsel.sarc.hardware.domain.LocationManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class HardwareModule {

    @Binds
    @Singleton
    abstract fun bindCameraManager(
        androidCameraManager: AndroidCameraManager
    ): CameraManager

    @Binds
    @Singleton
    abstract fun bindLocationManager(
        androidLocationManager: AndroidLocationManager
    ): LocationManager
}