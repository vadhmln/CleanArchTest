package ru.vdh.cleanarch.core.domain.exception

import ru.vdh.cleanarch.core.domain.exception.DomainException

class UnknownDomainException(throwable: Throwable) : DomainException(throwable) {
    constructor(errorMessage: String) : this(Throwable(errorMessage))
}
