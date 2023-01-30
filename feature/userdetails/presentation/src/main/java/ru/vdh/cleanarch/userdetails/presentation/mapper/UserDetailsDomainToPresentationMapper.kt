package ru.vdh.cleanarch.userdetails.presentation.mapper

import ru.vdh.cleanarch.userdetails.domain.model.UserNameDomainModel
import ru.vdh.cleanarch.userdetails.presentation.model.UserPresentationModel

class UserDetailsDomainToPresentationMapper {
    fun toPresentation(newUser: UserNameDomainModel) =
        UserPresentationModel(
            firstName = newUser.firstName,
            lastName = newUser.lastName
        )
}