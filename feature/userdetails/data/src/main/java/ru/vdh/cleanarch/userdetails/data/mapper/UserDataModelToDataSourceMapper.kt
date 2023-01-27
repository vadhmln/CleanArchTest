package ru.vdh.cleanarch.userdetails.data.mapper

import ru.vdh.cleanarch.userdetails.data.model.User
import ru.vdh.cleanarch.userdetails.domain.model.SaveUserNameParam
import javax.inject.Inject

class UserDataModelToDataSourceMapper @Inject constructor() {
    fun toDataSource(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }
}