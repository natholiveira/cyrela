package com.fiap.cyrela.exception

import org.springframework.http.HttpStatus

class TicketNumberAlreadyExistsException (message: String): ApiException(message) {

    override fun httpStatus(): HttpStatus = HttpStatus.NOT_ACCEPTABLE
    override fun apiError(): ApiError = ApiError.TICKET_NUMBER_AlREADY_EXISTS
    override fun userResponseMessage(): Any = "Unable to register"
}