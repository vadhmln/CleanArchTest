package ru.vdh.cleanarch.userdetails.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.vdh.cleanarch.core.presentation.viewmodel.BaseViewModel
import ru.vdh.cleanarch.core.presentation.viewmodel.usecase.UseCaseExecutorProvider
import ru.vdh.cleanarch.userdetails.domain.model.UserDetailsDomainModel
import ru.vdh.cleanarch.userdetails.domain.usecase.GetUserNameUseCase
import ru.vdh.cleanarch.userdetails.domain.usecase.SaveUserNameUseCase
import ru.vdh.cleanarch.userdetails.presentation.mapper.UserDetailsDomainToPresentationMapper
import ru.vdh.cleanarch.userdetails.presentation.mapper.UserDetailsPresentationToDomainMapper
import ru.vdh.cleanarch.userdetails.presentation.model.UserDetailsPresentationNotification
import ru.vdh.cleanarch.userdetails.presentation.model.UserDetailsViewState
import ru.vdh.cleanarch.userdetails.presentation.model.UserDetailsPresentationModel
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase,
    useCaseExecutorProvider: UseCaseExecutorProvider,
    private val userDetailsPresentationToDomainMapper: UserDetailsPresentationToDomainMapper,
    private val userDetailsDomainToPresentationMapper: UserDetailsDomainToPresentationMapper
) : BaseViewModel<UserDetailsViewState, UserDetailsPresentationNotification>(useCaseExecutorProvider) {

    override fun initialState() = UserDetailsViewState()

    private val resultMutableLiveData = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = resultMutableLiveData

    init {
        Log.e("AAA", "UserDetailsViewModel created!!!")
    }

    //вызывается когда связанная с ней активити/fragment уничтожается
    override fun onCleared() {
        Log.e("AAA", "UserDetailsViewModel cleared!!!")
        super.onCleared()
    }

    fun save(userDetailsPresentationModel: UserDetailsPresentationModel) {
        val domainNewUser =
            userDetailsPresentationToDomainMapper.toDomain(userDetailsPresentationModel)
        val result = execute(saveUserNameUseCase, domainNewUser)
        resultMutableLiveData.value = "Save result = $result"
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
//        execute(getUserNameUseCase, userName)
        resultMutableLiveData.value = "${userName.firstName} ${userName.lastName}"
    }

    private fun presentUserDetails(user: UserDetailsDomainModel) =
        userDetailsDomainToPresentationMapper.toPresentation(user)
}