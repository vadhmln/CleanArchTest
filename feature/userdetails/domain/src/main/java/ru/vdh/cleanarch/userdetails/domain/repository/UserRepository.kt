package ru.vdh.cleanarch.userdetails.domain.repository

import ru.vdh.cleanarch.userdetails.domain.model.SaveUserNameParam
import ru.vdh.cleanarch.userdetails.domain.model.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}