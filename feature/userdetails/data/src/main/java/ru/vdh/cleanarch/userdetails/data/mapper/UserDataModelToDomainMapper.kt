package ru.vdh.cleanarch.userdetails.data.mapper

import ru.vdh.cleanarch.userdetails.data.model.User
import ru.vdh.cleanarch.userdetails.domain.model.UserName
import javax.inject.Inject

class UserDataModelToDomainMapper @Inject constructor() {
    fun toDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}