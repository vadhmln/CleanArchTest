package ru.vdh.cleanarch.navigation.model

import androidx.navigation.NavController
import dagger.Lazy
import ru.vdh.cleanarch.core.ui.navigation.model.UiDestination

class BackUiDestination(
    private val lazyNavController: Lazy<NavController>
) : UiDestination {
    override fun navigate() {
        lazyNavController.get().popBackStack()
    }
}
