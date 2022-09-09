package com.toycommerce.member.shared.exception

import org.springframework.http.HttpStatus

/**
 * 최상위 티어 비지니스 예외 정의
 */
abstract class BusinessException : RuntimeException {
    constructor()
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)
    constructor(message: String?, cause: Throwable?, enableSuppression: Boolean, writableStackTrace: Boolean) :
            super(message, cause, enableSuppression, writableStackTrace)

    abstract val httpStatus: HttpStatus
    abstract val isNecessaryToLog: Boolean
}

/**
 * 400 요청이 잘못된경우
 */
class BadRequestException : BusinessException {
    constructor() {}
    constructor(message: String?) : super(message) {}
    constructor(message: String?, cause: Throwable?) : super(message, cause) {}
    constructor(cause: Throwable?) : super(cause) {}
    constructor(message: String?, cause: Throwable?, enableSuppression: Boolean, writableStackTrace: Boolean) :
            super(message, cause, enableSuppression, writableStackTrace)

    override val httpStatus: HttpStatus
        get() = HttpStatus.BAD_REQUEST
    override val isNecessaryToLog: Boolean
        get() = false
}

/**
 * 404 자원을 찾을수 없는 경우
 */
class ResourceNotFoundException : BusinessException {
    constructor() {}
    constructor(message: String?) : super(message) {}
    constructor(message: String?, cause: Throwable?) : super(message, cause) {}
    constructor(cause: Throwable?) : super(cause) {}
    constructor(message: String?, cause: Throwable?, enableSuppression: Boolean, writableStackTrace: Boolean) :
            super(message, cause, enableSuppression, writableStackTrace)

    override val httpStatus: HttpStatus
        get() = HttpStatus.NOT_FOUND
    override val isNecessaryToLog: Boolean
        get() = false
}

/**
 * 409 비지니스 로직상 모순이 발생하여 처리가 불가능한 경우
 */
class ResourceConflictException : BusinessException {
    constructor() {}
    constructor(message: String?) : super(message) {}
    constructor(message: String?, cause: Throwable?) : super(message, cause) {}
    constructor(cause: Throwable?) : super(cause) {}
    constructor(message: String?, cause: Throwable?, enableSuppression: Boolean, writableStackTrace: Boolean) :
            super(message, cause, enableSuppression, writableStackTrace)

    override val httpStatus: HttpStatus
        get() = HttpStatus.CONFLICT
    override val isNecessaryToLog: Boolean
        get() = false
}
