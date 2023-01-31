package ru.vdh.cleanarch.userdetails.data.mapper

import ru.vdh.cleanarch.userdetails.data.model.UserDetailsDataModel
import ru.vdh.cleanarch.userdetails.domain.model.UserDetailsDomainModel

class UserDataModelToDataSourceMapper {
    fun toDataSource(userName: UserDetailsDomainModel) =
        UserDetailsDataModel(firstName = userName.firstName, lastName = "")
}