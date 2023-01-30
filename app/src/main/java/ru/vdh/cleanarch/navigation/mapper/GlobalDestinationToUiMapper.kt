package ru.vdh.cleanarch.navigation.mapper

import androidx.navigation.NavController
import ru.vdh.cleanarch.navigation.model.UnhandledDestinationException
import dagger.Lazy
import ru.vdh.cleanarch.core.presentation.model.PresentationDestination
import ru.vdh.cleanarch.core.ui.navigation.mapper.DestinationPresentationToUiMapper
import ru.vdh.cleanarch.core.ui.navigation.model.UiDestination

class GlobalDestinationToUiMapper(
    private val lazyNavController: Lazy<NavController>
) : DestinationPresentationToUiMapper {
    override fun toUi(
        input: PresentationDestination
    ): UiDestination = when (input) {
        PresentationDestination.Back -> BackUiDestination(lazyNavController)
        else -> throw UnhandledDestinationException(input)
    }

    private class BackUiDestination(
        private val lazyNavController: Lazy<NavController>
    ) : UiDestination {
        override fun navigate() {
            lazyNavController.get().popBackStack()
        }
    }
}
