package ru.vdh.cleanarch.userdetails.data.repository

import ru.vdh.cleanarch.userdetails.data.datasource.UserDataSource
import ru.vdh.cleanarch.userdetails.data.mapper.UserDataModelToDataSourceMapper
import ru.vdh.cleanarch.userdetails.data.mapper.UserDataModelToDomainMapper
import ru.vdh.cleanarch.userdetails.domain.model.UserDetailsDomainModel
import ru.vdh.cleanarch.userdetails.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userDataSource: UserDataSource,
    private val userDataModelToDomainMapper: UserDataModelToDomainMapper,
    private val userDataModelToDataSourceMapper: UserDataModelToDataSourceMapper
) : UserRepository {

    override fun saveName(userName: UserDetailsDomainModel): Boolean {
        val user = userDataModelToDataSourceMapper.toDataSource(userName)
        return userDataSource.save(user)
    }

    override fun getName(): UserDetailsDomainModel {
        val user = userDataSource.get()
        return userDataModelToDomainMapper.toDomain(user)
    }
}


