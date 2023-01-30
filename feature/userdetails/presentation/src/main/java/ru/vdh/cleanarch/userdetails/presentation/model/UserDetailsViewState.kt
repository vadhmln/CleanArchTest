package ru.vdh.cleanarch.userdetails.presentation.model

data class UserDetailsViewState(
    val saveResult: Boolean = false,
    val firstName: String = "",
    val lastName: String = ""
)