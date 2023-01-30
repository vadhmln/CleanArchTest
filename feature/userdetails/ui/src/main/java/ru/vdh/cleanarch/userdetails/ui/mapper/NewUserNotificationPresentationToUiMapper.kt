package ru.vdh.cleanarch.userdetails.ui.mapper

import ru.vdh.cleanarch.core.ui.mapper.NotificationPresentationToUiMapper
import ru.vdh.cleanarch.core.ui.model.NotificationUiModel
import ru.vdh.cleanarch.userdetails.presentation.model.UserDetailsPresentationNotification

class NewUserNotificationPresentationToUiMapper :
    NotificationPresentationToUiMapper<UserDetailsPresentationNotification> {
    override fun toUi(
        presentationNotification: UserDetailsPresentationNotification
    ): NotificationUiModel {
        throw IllegalStateException("Notifications not supported.")
    }
}
