package com.fiap.cyrela.controller

import com.fiap.cyrela.exception.BadRequestExceptioin
import com.fiap.cyrela.request.DevelopmentRequest
import com.fiap.cyrela.request.UserRequest
import com.fiap.cyrela.service.DevelopmentService
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class DevelopmentController(
        private val developmentService: DevelopmentService
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/development")
    @ApiOperation(value = "Create new Development")
    @ApiResponses(value = arrayOf(
            ApiResponse(code = 201, message = "Created new Development"),
            ApiResponse(code = 400, message = "Bad Request"),
    ))
    fun createDevelopment(@RequestBody @Valid developmentRequest: DevelopmentRequest
                   ,bindingResult: BindingResult) =
            if (bindingResult.hasErrors()) {
                throw BadRequestExceptioin()
            } else developmentService.createDevelopment(developmentRequest)
}