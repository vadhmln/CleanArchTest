package ru.vdh.cleanarch.userdetails.domain.usecase

import ru.vdh.cleanarch.userdetails.domain.model.SaveUserNameParam
import ru.vdh.cleanarch.userdetails.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        //данная проверка проводится в презентейшн слое, здесь для демонстрации
        val oldUserName = userRepository.getName()
        if (oldUserName.firstName == param.name){
            return true
        }
        return userRepository.saveName(saveParam = param)
    }
}



