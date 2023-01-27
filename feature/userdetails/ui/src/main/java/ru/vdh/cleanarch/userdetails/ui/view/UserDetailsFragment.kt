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
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.vdh.cleanarch.feature.feature1.ui.R
import ru.vdh.cleanarch.userdetails.presentation.viewmodel.UserDetailsViewModel

private const val NO_LAYOUT_RESOURCE = 0

@AndroidEntryPoint
class UserDetailsFragment : Fragment() {

    private val viewModel: UserDetailsViewModel by viewModels()

    private val layoutResourceId = R.layout.user_details_fragment

    lateinit var userNameField: TextView
    lateinit var dataEditView: EditText
    lateinit var getUserNameButton: View
    lateinit var saveUserNameButton: View

    private fun View.bindViews() {
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
            viewModel.save(text)
        }
    }


    companion object {
        private const val ARGUMENT_RESTAURANT_ID = "UserName"

        fun newInstance(userName: String) = UserDetailsFragment().apply {
            arguments = bundleOf(ARGUMENT_RESTAURANT_ID to userName)
        }
    }

}