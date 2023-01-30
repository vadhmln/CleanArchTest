package ru.vdh.cleanarch.userdetails.ui.mapper

import ru.vdh.cleanarch.core.ui.navigation.mapper.DestinationPresentationToUiMapper
import ru.vdh.cleanarch.core.ui.navigation.model.UiDestination

interface NewUserDestinationToUiMapper : DestinationPresentationToUiMapper {
    abstract class NewDishSuccessUiDestination(
        open val dishId: String
    ) : UiDestination
}
