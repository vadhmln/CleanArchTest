package ru.vdh.cleanarch.userdetails.data.repository

import ru.vdh.cleanarch.userdetails.data.datasource.UserDataSource
import ru.vdh.cleanarch.userdetails.data.mapper.UserDataModelToDataSourceMapper
import ru.vdh.cleanarch.userdetails.data.mapper.UserDataModelToDomainMapper
import ru.vdh.cleanarch.userdetails.data.model.UserDataModel
import ru.vdh.cleanarch.userdetails.domain.model.SaveUserNameParam
import ru.vdh.cleanarch.userdetails.domain.model.UserNameDomainModel
import ru.vdh.cleanarch.userdetails.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userDataSource: UserDataSource,
    private val userDataModelToDomainMapper: UserDataModelToDomainMapper,
    private val userDataModelToDataSourceMapper: UserDataModelToDataSourceMapper
) : UserRepository {

    override fun saveName(userName: UserNameDomainModel): Boolean {
        val user = userDataModelToDataSourceMapper.toDataSource(userName)
        return userDataSource.save(user)
    }

    override fun getName(): UserNameDomainModel {
        val user = userDataSource.get()
        return userDataModelToDomainMapper.toDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): UserDataModel {
        return UserDataModel(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(userDataModel: UserDataModel): UserNameDomainModel {
        return UserNameDomainModel(firstName = userDataModel.firstName, lastName = userDataModel.lastName)
    }
}


