package ru.vdh.cleanarch.userdetails.ui.binder

import ru.vdh.cleanarch.core.ui.mapper.ViewStateBinder
import ru.vdh.cleanarch.userdetails.presentation.model.UserDetailsViewState
import ru.vdh.cleanarch.userdetails.ui.view.UserDetailsViewsProvider

class UserDetailsViewStateBinder :
    ViewStateBinder<UserDetailsViewState, UserDetailsViewsProvider> {
    override fun UserDetailsViewsProvider
            .bindState(viewState: UserDetailsViewState) = Unit
}