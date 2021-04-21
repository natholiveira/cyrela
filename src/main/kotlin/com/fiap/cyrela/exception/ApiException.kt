package com.fiap.cyrela.exception

import org.springframework.http.HttpStatus

abstract class ApiException : Exception {

    constructor(cause: Throwable?) : super(cause)
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable?): super(message, cause)

    abstract fun httpStatus(): HttpStatus
    abstract fun apiError(): ApiError
    abstract fun userResponseMessage(): Any

    fun createErrorResponse(): ErrorResponse {
        return ErrorResponse(
                apiError(),
                userResponseMessage()
        )
    }
}