package com.williamsel.sarc.features.publico.login.di

import com.williamsel.sarc.features.publico.login.data.repositories.LoginRepositoryImpl
import com.williamsel.sarc.features.publico.login.domain.repositories.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LoginModule {

    @Binds
    @Singleton
    abstract fun bindLoginRepository(
        impl: LoginRepositoryImpl
    ): LoginRepository
}
