package ru.vdh.cleanarch.app.navigation

import ru.vdh.cleanarch.core.presentation.model.PresentationDestination
import ru.vdh.cleanarch.core.ui.navigation.model.UiDestination
import ru.vdh.cleanarch.navigation.mapper.GlobalDestinationToUiMapper
import ru.vdh.cleanarch.userdetails.ui.mapper.NewUserDestinationToUiMapper

class AppUserDetailsDestinationToUiMapper(
    private val globalDestinationToUiMapper: GlobalDestinationToUiMapper
) : NewUserDestinationToUiMapper {
    override fun toUi(
        input: PresentationDestination
    ): UiDestination = when (input) {
        else -> globalDestinationToUiMapper.toUi(input)
    }

//    object GoNowhere : DishDetailsUiDestination {
//        override fun navigate() = Unit
//    }
}
