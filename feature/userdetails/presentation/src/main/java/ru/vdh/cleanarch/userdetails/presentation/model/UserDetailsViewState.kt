package ru.vdh.cleanarch.userdetails.presentation.model

import javax.inject.Inject

data class UserDetailsViewState(
    val saveResult: Boolean = false,
    val firstName: String = "",
    val lastName: String = ""
)