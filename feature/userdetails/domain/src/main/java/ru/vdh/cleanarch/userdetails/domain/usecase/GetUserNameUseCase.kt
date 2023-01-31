package ru.vdh.cleanarch.userdetails.domain.usecase

import ru.vdh.cleanarch.core.domain.coroutine.CoroutineContextProvider
import ru.vdh.cleanarch.core.domain.usecase.BackgroundExecutingUseCase
import ru.vdh.cleanarch.userdetails.domain.model.UserDetailsDomainModel
import ru.vdh.cleanarch.userdetails.domain.repository.UserRepository

class GetUserNameUseCase(
    private val userRepository: UserRepository,
    private val coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<UserDetailsDomainModel, UserDetailsDomainModel>(coroutineContextProvider) {

    fun execute(): UserDetailsDomainModel {
        return userRepository.getName()
    }

    override fun executeInBackground(request: UserDetailsDomainModel) = userRepository.getName()
}