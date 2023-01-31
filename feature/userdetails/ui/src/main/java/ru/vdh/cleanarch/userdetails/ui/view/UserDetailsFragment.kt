package ru.vdh.cleanarch.userdetails.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.vdh.cleanarch.core.ui.mapper.ViewStateBinder
import ru.vdh.cleanarch.core.ui.view.BaseFragment
import ru.vdh.cleanarch.core.ui.view.ViewsProvider
import ru.vdh.cleanarch.userdetails.presentation.model.UserDetailsPresentationNotification
import ru.vdh.cleanarch.userdetails.presentation.model.UserDetailsViewState
import ru.vdh.cleanarch.userdetails.presentation.model.UserDetailsPresentationModel
import ru.vdh.cleanarch.userdetails.presentation.viewmodel.UserDetailsViewModel
import ru.vdh.cleanarch.userdetails.ui.R
import ru.vdh.cleanarch.userdetails.ui.mapper.NewUserDestinationToUiMapper
import ru.vdh.cleanarch.userdetails.ui.mapper.NewUserNotificationPresentationToUiMapper
import javax.inject.Inject

private const val NO_LAYOUT_RESOURCE = 0

@AndroidEntryPoint
class UserDetailsFragment : BaseFragment<UserDetailsViewState, UserDetailsPresentationNotification>(),
    UserDetailsViewsProvider {

    override val viewModel: UserDetailsViewModel by viewModels()

    override val layoutResourceId = R.layout.user_details_fragment

    @Inject
    override lateinit var destinationMapper:
            NewUserDestinationToUiMapper

    @Inject
    override lateinit var notificationMapper:
            NewUserNotificationPresentationToUiMapper

    @Inject
    @JvmSuppressWildcards
    override lateinit var viewStateBinder:
            ViewStateBinder<UserDetailsViewState, ViewsProvider>

    override lateinit var userNameField: TextView
    override lateinit var dataEditView: EditText
    override lateinit var getUserNameButton: View
    override lateinit var saveUserNameButton: View

    override fun View.bindViews() {
        userNameField = findViewById(R.id.userDetailsTextView)
        dataEditView = findViewById(R.id.dataEditText)
        getUserNameButton = findViewById<Button>(R.id.get_user_details_button)
        saveUserNameButton = findViewById<Button>(R.id.save_data_button)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        Log.e("AAA", "UserDetailsFragment created!!!")

        //подписка на изменение данных
        viewModel.resultLiveData.observe(viewLifecycleOwner) {
            userNameField.text = it
        }

        val view = if (layoutResourceId != NO_LAYOUT_RESOURCE) {
            inflater.inflate(layoutResourceId, container, false).apply {
                bindViews()
            }
        } else {
            null
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getUserNameButton.setOnClickListener {
            viewModel.load()
        }

        saveUserNameButton.setOnClickListener {
            val text = dataEditView.text.toString()
            viewModel.save(UserDetailsPresentationModel(firstName = text))
        }
    }

    companion object {
        private const val ARGUMENT_RESTAURANT_ID = "UserName"

        fun newInstance(userName: String) = UserDetailsFragment().apply {
            arguments = bundleOf(ARGUMENT_RESTAURANT_ID to userName)
        }
    }

}