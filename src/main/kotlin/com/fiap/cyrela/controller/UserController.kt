package com.fiap.cyrela.controller

import com.fiap.cyrela.exception.BadRequestExceptioin
import com.fiap.cyrela.request.OccurrenceRequest
import com.fiap.cyrela.request.UserRequest
import com.fiap.cyrela.service.UserService
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
class UserController(
        private val userService: UserService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/user")
    @ApiOperation(value = "Create new User")
    @ApiResponses(value = arrayOf(
            ApiResponse(code = 201, message = "Created new User"),
            ApiResponse(code = 400, message = "Bad Request"),
    ))
    fun createUser(@RequestBody @Valid userRequest: UserRequest
                         ,bindingResult: BindingResult) =
            if (bindingResult.hasErrors()) {
                throw BadRequestExceptioin()
            } else userService.createUser(userRequest)

}