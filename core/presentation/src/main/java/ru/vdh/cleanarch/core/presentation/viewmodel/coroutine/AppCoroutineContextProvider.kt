package ru.vdh.cleanarch.core.presentation.viewmodel.coroutine

import kotlinx.coroutines.Dispatchers
import ru.vdh.cleanarch.core.domain.coroutine.CoroutineContextProvider

class AppCoroutineContextProvider : CoroutineContextProvider {
    override val main = Dispatchers.Main
    override val io = Dispatchers.IO
}
