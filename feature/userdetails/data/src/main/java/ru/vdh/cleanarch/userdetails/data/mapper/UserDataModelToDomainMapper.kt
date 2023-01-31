package ru.vdh.cleanarch.userdetails.data.mapper

import ru.vdh.cleanarch.userdetails.data.model.UserDetailsDataModel
import ru.vdh.cleanarch.userdetails.domain.model.UserDetailsDomainModel

class UserDataModelToDomainMapper {
    fun toDomain(userDetailsDataModel: UserDetailsDataModel) =
        UserDetailsDomainModel(firstName = userDetailsDataModel.firstName, lastName = userDetailsDataModel.lastName)
}