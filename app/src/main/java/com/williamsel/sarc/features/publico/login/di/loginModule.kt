package com.williamsel.sarc.login.di

import com.williamsel.sarc.login.data.datasource.api.loginApi
import com.williamsel.sarc.login.data.repositories.loginImpl
import com.williamsel.sarc.login.domain.repositories.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object loginModule {

    @Provides
    fun provideLoginRepository(
        api: loginApi
    ): LoginRepository {
        return loginImpl(api)
    }
}