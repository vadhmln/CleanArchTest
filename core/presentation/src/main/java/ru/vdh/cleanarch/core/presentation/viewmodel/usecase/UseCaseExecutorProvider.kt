package ru.vdh.cleanarch.core.presentation.viewmodel.usecase

import kotlinx.coroutines.CoroutineScope
import ru.vdh.cleanarch.core.domain.usecase.UseCaseExecutor

typealias UseCaseExecutorProvider =
    @JvmSuppressWildcards (coroutineScope: CoroutineScope) -> UseCaseExecutor
