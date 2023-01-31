package ru.vdh.cleanarch.userdetails.presentation.mapper

import ru.vdh.cleanarch.userdetails.domain.model.UserDetailsDomainModel
import ru.vdh.cleanarch.userdetails.presentation.model.UserDetailsPresentationModel

class UserDetailsPresentationToDomainMapper {
    fun toDomain(newUser: UserDetailsPresentationModel) =
        UserDetailsDomainModel(
            firstName = newUser.firstName,
            lastName = newUser.lastName
        )
}
