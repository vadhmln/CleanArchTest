package ru.vdh.cleanarch.core.ui.mapper

import ru.vdh.cleanarch.core.ui.model.NotificationUiModel

interface NotificationPresentationToUiMapper<PRESENTATION_NOTIFICATION : Any> {
    fun toUi(presentationNotification: PRESENTATION_NOTIFICATION): NotificationUiModel
}
