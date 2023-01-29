package ru.vdh.cleanarch.core.ui.navigation.mapper

import ru.vdh.cleanarch.core.presentation.model.PresentationDestination
import ru.vdh.cleanarch.core.ui.navigation.model.UiDestination

interface DestinationPresentationToUiMapper {
    fun toUi(input: PresentationDestination): UiDestination
}
