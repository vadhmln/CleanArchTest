package ru.vdh.cleanarch.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import ru.vdh.cleanarch.core.domain.coroutine.CoroutineContextProvider
import ru.vdh.cleanarch.userdetails.domain.repository.UserRepository
import ru.vdh.cleanarch.userdetails.domain.usecase.GetUserNameUseCase
import ru.vdh.cleanarch.userdetails.domain.usecase.SaveUserNameUseCase

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetUserNameUseCase(
        userRepository: UserRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): GetUserNameUseCase =
        GetUserNameUseCase(
            userRepository = userRepository,
            coroutineContextProvider = coroutineContextProvider
        )


    @Provides
    fun provideSaveUserNameUseCase(
        userRepository: UserRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): SaveUserNameUseCase =
        SaveUserNameUseCase(
            userRepository = userRepository,
            coroutineContextProvider = coroutineContextProvider
        )

}