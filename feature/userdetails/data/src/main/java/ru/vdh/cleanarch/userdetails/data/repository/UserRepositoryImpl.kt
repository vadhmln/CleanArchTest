package ru.vdh.cleanarch.userdetails.data.repository

import ru.vdh.cleanarch.userdetails.data.datasource.UserDataSource
import ru.vdh.cleanarch.userdetails.data.mapper.UserDataModelToDataSourceMapper
import ru.vdh.cleanarch.userdetails.data.mapper.UserDataModelToDomainMapper
import ru.vdh.cleanarch.userdetails.data.model.User
import ru.vdh.cleanarch.userdetails.domain.model.SaveUserNameParam
import ru.vdh.cleanarch.userdetails.domain.model.UserName
import ru.vdh.cleanarch.userdetails.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userDataSource: UserDataSource,
    private val userDataModelToDomainMapper: UserDataModelToDomainMapper,
    private val userDataModelToDataSourceMapper: UserDataModelToDataSourceMapper
) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = userDataModelToDataSourceMapper.toDataSource(saveParam)
        return userDataSource.save(user)
    }

    override fun getName(): UserName {
        val user = userDataSource.get()
        return userDataModelToDomainMapper.toDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}


