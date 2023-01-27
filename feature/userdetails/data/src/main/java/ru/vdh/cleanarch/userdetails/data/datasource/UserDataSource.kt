package ru.vdh.cleanarch.userdetails.data.datasource

import ru.vdh.cleanarch.userdetails.data.model.User

interface UserDataSource {
    fun save(user: User): Boolean

    fun get(): User
}