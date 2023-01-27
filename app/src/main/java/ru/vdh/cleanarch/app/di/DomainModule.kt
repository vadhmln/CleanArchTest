package ru.vdh.cleanarch.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import ru.vdh.cleanarch.userdetails.domain.repository.UserRepository
import ru.vdh.cleanarch.userdetails.domain.usecase.GetUserNameUseCase
import ru.vdh.cleanarch.userdetails.domain.usecase.SaveUserNameUseCase

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase =
        GetUserNameUseCase(userRepository = userRepository)


    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase =
        SaveUserNameUseCase(userRepository = userRepository)

}