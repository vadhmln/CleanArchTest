package ru.vdh.cleanarch.userdetails.domain.usecase

import ru.vdh.cleanarch.core.domain.coroutine.CoroutineContextProvider
import ru.vdh.cleanarch.core.domain.usecase.BackgroundExecutingUseCase
import ru.vdh.cleanarch.userdetails.domain.model.UserNameDomainModel
import ru.vdh.cleanarch.userdetails.domain.repository.UserRepository

class GetUserNameUseCase(
    private val userRepository: UserRepository,
    private val coroutineContextProvider: CoroutineContextProvider
): BackgroundExecutingUseCase<UserNameDomainModel, UserNameDomainModel>(coroutineContextProvider) {

    fun execute(): UserNameDomainModel {
        return userRepository.getName()
    }

    override fun executeInBackground(request: UserNameDomainModel) = userRepository.getName()
}