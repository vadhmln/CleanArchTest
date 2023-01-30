package ru.vdh.cleanarch.userdetails.datasource

import android.content.Context
import ru.vdh.cleanarch.userdetails.data.datasource.UserDataSource
import ru.vdh.cleanarch.userdetails.data.model.UserDataModel

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_FIRST_NAME = "Default first name"
private const val DEFAULT_LAST_NAME = "Default last name"

class SharedPrefUserDataSource(context: Context) : UserDataSource {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(userDataModel: UserDataModel): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, userDataModel.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, userDataModel.lastName).apply()
        return true
    }

    override fun get(): UserDataModel {
        val firstName =
            sharedPreferences.getString(KEY_FIRST_NAME, DEFAULT_FIRST_NAME) ?: DEFAULT_FIRST_NAME
        val lastName =
            sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME) ?: DEFAULT_LAST_NAME
        return UserDataModel(firstName = firstName, lastName = lastName)
    }
}