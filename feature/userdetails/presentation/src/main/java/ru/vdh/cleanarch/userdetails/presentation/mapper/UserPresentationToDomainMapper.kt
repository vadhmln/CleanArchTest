package ru.vdh.cleanarch.userdetails.presentation.mapper

import ru.vdh.cleanarch.userdetails.domain.model.UserNameDomainModel
import ru.vdh.cleanarch.userdetails.presentation.model.UserPresentationModel

class UserPresentationToDomainMapper {
    fun toDomain(newUser: UserPresentationModel) =
        UserNameDomainModel(
            firstName = newUser.firstName,
            lastName = newUser.lastName
        )
}
