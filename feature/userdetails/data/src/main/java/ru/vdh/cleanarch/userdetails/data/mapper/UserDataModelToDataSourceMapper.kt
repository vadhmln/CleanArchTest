package ru.vdh.cleanarch.userdetails.data.mapper

import ru.vdh.cleanarch.userdetails.data.model.UserDataModel
import ru.vdh.cleanarch.userdetails.domain.model.UserNameDomainModel

class UserDataModelToDataSourceMapper {
    fun toDataSource(userName: UserNameDomainModel) =
        UserDataModel(firstName = userName.firstName, lastName = "")
}