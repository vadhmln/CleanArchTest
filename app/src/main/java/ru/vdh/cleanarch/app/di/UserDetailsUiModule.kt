package ru.vdh.cleanarch.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ru.vdh.cleanarch.core.ui.mapper.ViewStateBinder
import ru.vdh.cleanarch.core.ui.view.ViewsProvider
import ru.vdh.cleanarch.userdetails.data.mapper.UserDataModelToDomainMapper
import ru.vdh.cleanarch.userdetails.presentation.model.UserDetailsViewState
import ru.vdh.cleanarch.userdetails.ui.binder.UserDetailsViewStateBinder
import ru.vdh.cleanarch.userdetails.ui.mapper.NewUserNotificationPresentationToUiMapper

@Module
@InstallIn(FragmentComponent::class)
class UserDetailsUiModule {

    @Provides
    @Suppress("UNCHECKED_CAST")
    fun providesUserDetailsViewStateBinder() = UserDetailsViewStateBinder()
            as ViewStateBinder<UserDetailsViewState, ViewsProvider>

    @Provides
    fun providesNewUserNotificationPresentationToUiMapper() =
        NewUserNotificationPresentationToUiMapper()
}