package ru.vdh.cleanarch.userdetails.domain.usecase

import ru.vdh.cleanarch.userdetails.domain.model.UserName
import ru.vdh.cleanarch.userdetails.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}