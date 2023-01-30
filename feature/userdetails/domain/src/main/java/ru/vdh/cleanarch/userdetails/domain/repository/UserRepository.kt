package ru.vdh.cleanarch.userdetails.domain.repository

import ru.vdh.cleanarch.userdetails.domain.model.UserNameDomainModel

interface UserRepository {

    fun saveName(userName: UserNameDomainModel): Boolean

    fun getName(): UserNameDomainModel
}