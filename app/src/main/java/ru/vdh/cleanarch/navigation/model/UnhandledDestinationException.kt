package ru.vdh.cleanarch.navigation.model

import ru.vdh.cleanarch.core.presentation.model.PresentationDestination

class UnhandledDestinationException(
    destination: PresentationDestination
) : IllegalArgumentException(
    "Navigation to ${destination::class.simpleName} was not handled."
)
