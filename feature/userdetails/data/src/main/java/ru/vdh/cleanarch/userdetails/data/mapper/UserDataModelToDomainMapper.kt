package ru.vdh.cleanarch.userdetails.data.mapper

import ru.vdh.cleanarch.userdetails.data.model.UserDataModel
import ru.vdh.cleanarch.userdetails.domain.model.UserNameDomainModel

class UserDataModelToDomainMapper {
    fun toDomain(userDataModel: UserDataModel) =
        UserNameDomainModel(firstName = userDataModel.firstName, lastName = userDataModel.lastName)
}