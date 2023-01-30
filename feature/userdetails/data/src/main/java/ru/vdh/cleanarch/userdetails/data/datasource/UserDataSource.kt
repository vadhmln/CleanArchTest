package ru.vdh.cleanarch.userdetails.data.datasource

import ru.vdh.cleanarch.userdetails.data.model.UserDataModel

interface UserDataSource {
    fun save(userDataModel: UserDataModel): Boolean

    fun get(): UserDataModel
}