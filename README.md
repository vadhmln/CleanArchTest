# CleanArchitectureTemplateAndroidView
Цель этого шаблона - стать отправной точкой для новых проектов, следуя лучшим практикам разработки.

# Чистая архитектура с 3 основными модулями
- Data (для базы данных, API и кода настроек)
- Domain (для бизнес-логики и моделей)
- App (для логики пользовательского интерфейса, с MVVM)

# Другие полезные функции
- Эта версия обеспечивает модульность ([Modularization](https://developer.android.com/topic/modularization))
- Управление версиями ([Version catalog](https://docs.gradle.org/current/userguide/platforms.html))

# Начало работы

1. Загрузите этот репозиторий и откройте папку CleanArchitectureTemplateAndroidView в Android Studio
2. Переименуйте иерархию "ru.vdh.cleanarch" в необходимую.
3. Проверьте, была ли иерархия в манифесте переименована в соответствии с этим.
4. В `app/build.gradle` измените идентификатор приложения на новую иерархию.
5. В `string.xml`, установите название вашего приложения
6. В `settings.gradle` в `rootProject.name` установите название корнего проекта 