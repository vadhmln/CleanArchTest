package ru.vdh.cleanarch.userdetails.ui.view

import android.view.View
import android.widget.EditText
import android.widget.TextView
import ru.vdh.cleanarch.core.ui.view.ViewsProvider

interface UserDetailsViewsProvider : ViewsProvider {
    val userNameField: TextView
    val dataEditView: EditText
    val getUserNameButton: View
    val saveUserNameButton: View
}
