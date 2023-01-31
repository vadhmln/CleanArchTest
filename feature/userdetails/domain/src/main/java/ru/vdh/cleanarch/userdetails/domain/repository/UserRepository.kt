package ru.vdh.cleanarch.userdetails.domain.repository

import ru.vdh.cleanarch.userdetails.domain.model.UserDetailsDomainModel

interface UserRepository {

    fun saveName(userName: UserDetailsDomainModel): Boolean

    fun getName(): UserDetailsDomainModel
}