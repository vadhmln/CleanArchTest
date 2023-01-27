package ru.vdh.cleanarch.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import ru.vdh.cleanarch.R
import ru.vdh.cleanarch.userdetails.ui.view.UserDetailsFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("AAA", "Activity created!!!")

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(R.id.main_fragment_container, UserDetailsFragment())
//                add(R.id.main_fragment_container, UserDetailsFragment.newInstance("RES1"))
                setReorderingAllowed(true)
                addToBackStack("name") // name can be null
            }
        }
    }
}