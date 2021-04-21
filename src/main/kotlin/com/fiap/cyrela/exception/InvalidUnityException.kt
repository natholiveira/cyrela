package com.fiap.cyrela.exception

import org.springframework.http.HttpStatus

class InvalidUnityException(message: String): ApiException(message) {

    override fun httpStatus(): HttpStatus = HttpStatus.NOT_FOUND
    override fun apiError(): ApiError = ApiError.UNITY_NOT_FOUND
    override fun userResponseMessage(): Any = "Unable to register"
}