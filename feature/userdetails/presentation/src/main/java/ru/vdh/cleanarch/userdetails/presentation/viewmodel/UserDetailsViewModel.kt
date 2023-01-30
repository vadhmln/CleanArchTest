package ru.vdh.cleanarch.userdetails.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.vdh.cleanarch.core.presentation.viewmodel.BaseViewModel
import ru.vdh.cleanarch.core.presentation.viewmodel.usecase.UseCaseExecutorProvider
import ru.vdh.cleanarch.userdetails.domain.model.SaveUserNameParam
import ru.vdh.cleanarch.userdetails.domain.model.UserNameDomainModel
import ru.vdh.cleanarch.userdetails.domain.usecase.GetUserNameUseCase
import ru.vdh.cleanarch.userdetails.domain.usecase.SaveUserNameUseCase
import ru.vdh.cleanarch.userdetails.presentation.mapper.UserDetailsDomainToPresentationMapper
import ru.vdh.cleanarch.userdetails.presentation.mapper.UserPresentationToDomainMapper
import ru.vdh.cleanarch.userdetails.presentation.model.UserDetailsPresentationNotification
import ru.vdh.cleanarch.userdetails.presentation.model.UserDetailsViewState
import ru.vdh.cleanarch.userdetails.presentation.model.UserPresentationModel
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase,
    useCaseExecutorProvider: UseCaseExecutorProvider,
    private val userPresentationToDomainMapper: UserPresentationToDomainMapper,
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

    fun save(userPresentationModel: UserPresentationModel) {
        val domainNewUser = userPresentationToDomainMapper.toDomain(userPresentationModel)
        val result = execute(saveUserNameUseCase, domainNewUser)
        resultMutableLiveData.value = "Save result = $result"
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        execute(getUserNameUseCase, userName)
        resultMutableLiveData.value = "${userName.firstName} ${userName.lastName}"
    }

    private fun presentUserDetails(user: UserNameDomainModel) {
        val userDetails = userDetailsDomainToPresentationMapper
            .toPresentation(user)
    }


}