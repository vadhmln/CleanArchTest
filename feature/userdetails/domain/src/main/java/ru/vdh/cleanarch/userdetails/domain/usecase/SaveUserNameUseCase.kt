package ru.vdh.cleanarch.userdetails.domain.usecase

import ru.vdh.cleanarch.core.domain.coroutine.CoroutineContextProvider
import ru.vdh.cleanarch.core.domain.usecase.BackgroundExecutingUseCase
import ru.vdh.cleanarch.userdetails.domain.model.UserNameDomainModel
import ru.vdh.cleanarch.userdetails.domain.repository.UserRepository

class SaveUserNameUseCase(
    private val userRepository: UserRepository,
    private val coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<UserNameDomainModel, Boolean>(coroutineContextProvider) {

//    fun execute(param: SaveUserNameParam): Boolean {
//        //данная проверка проводится в презентейшн слое, здесь для демонстрации
//        val oldUserName = userRepository.getName()
//        if (oldUserName.firstName == param.name) {
//            return true
//        }
//        return userRepository.saveName(saveParam = param)
//    }

    override fun executeInBackground(request: UserNameDomainModel): Boolean {
        //данная проверка проводится в презентейшн слое, здесь для демонстрации
        val oldUserName = userRepository.getName()
        if (oldUserName.firstName == request.firstName) {
            return true
        }
        return userRepository.saveName(userName = request)
    }
}



