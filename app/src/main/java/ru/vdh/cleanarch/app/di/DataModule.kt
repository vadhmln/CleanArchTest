package ru.vdh.cleanarch.app.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.vdh.cleanarch.userdetails.data.datasource.UserDataSource
import ru.vdh.cleanarch.userdetails.data.mapper.UserDataModelToDataSourceMapper
import ru.vdh.cleanarch.userdetails.data.mapper.UserDataModelToDomainMapper
import ru.vdh.cleanarch.userdetails.data.repository.UserRepositoryImpl
import ru.vdh.cleanarch.userdetails.datasource.SharedPrefUserDataSource
import ru.vdh.cleanarch.userdetails.domain.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideUserDataSource(@ApplicationContext context: Context): UserDataSource {
        return SharedPrefUserDataSource(context = context)
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        userDataSource: UserDataSource,
        userDataModelToDomainMapper: UserDataModelToDomainMapper,
        userDataModelToDataSourceMapper: UserDataModelToDataSourceMapper
    ): UserRepository = UserRepositoryImpl(
        userDataSource = userDataSource,
        userDataModelToDomainMapper,
        userDataModelToDataSourceMapper
    )

}