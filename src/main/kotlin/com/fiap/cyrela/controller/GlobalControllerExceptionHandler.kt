package com.fiap.cyrela.controller

import com.fiap.cyrela.exception.ApiException
import com.fiap.cyrela.exception.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalControllerExceptionHandler {
    @ExceptionHandler(ApiException::class)
    fun handleValidationError(ex: ApiException): ResponseEntity<ErrorResponse> =
            ResponseEntity.status(ex.httpStatus()).body(ex.createErrorResponse())
}