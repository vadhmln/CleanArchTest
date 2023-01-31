package ru.vdh.cleanarch.userdetails.data.datasource

import ru.vdh.cleanarch.userdetails.data.model.UserDetailsDataModel

interface UserDataSource {
    fun save(userDetailsDataModel: UserDetailsDataModel): Boolean

    fun get(): UserDetailsDataModel
}