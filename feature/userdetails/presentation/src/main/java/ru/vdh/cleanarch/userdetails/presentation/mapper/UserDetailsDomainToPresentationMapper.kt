package ru.vdh.cleanarch.userdetails.presentation.mapper

import ru.vdh.cleanarch.userdetails.domain.model.UserDetailsDomainModel
import ru.vdh.cleanarch.userdetails.presentation.model.UserDetailsPresentationModel

class UserDetailsDomainToPresentationMapper {
    fun toPresentation(user: UserDetailsDomainModel) =
        UserDetailsPresentationModel(
            firstName = user.firstName,
            lastName = user.lastName
        )
}