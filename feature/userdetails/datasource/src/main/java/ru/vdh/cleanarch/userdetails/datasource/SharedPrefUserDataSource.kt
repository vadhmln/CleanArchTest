package ru.vdh.cleanarch.userdetails.datasource

import android.content.Context
import ru.vdh.cleanarch.userdetails.data.datasource.UserDataSource
import ru.vdh.cleanarch.userdetails.data.model.UserDetailsDataModel

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_FIRST_NAME = "Default first name"
private const val DEFAULT_LAST_NAME = "Default last name"

class SharedPrefUserDataSource(context: Context) : UserDataSource {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(userDetailsDataModel: UserDetailsDataModel): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, userDetailsDataModel.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, userDetailsDataModel.lastName).apply()
        return true
    }

    override fun get(): UserDetailsDataModel {
        val firstName =
            sharedPreferences.getString(KEY_FIRST_NAME, DEFAULT_FIRST_NAME) ?: DEFAULT_FIRST_NAME
        val lastName =
            sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME) ?: DEFAULT_LAST_NAME
        return UserDetailsDataModel(firstName = firstName, lastName = lastName)
    }
}