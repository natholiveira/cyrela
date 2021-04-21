package com.fiap.cyrela.request

import java.util.Date
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class UserRequest (
        @field:NotNull
        @field:NotBlank
        val name: String? = null,

        @field:NotNull
        val birthday: Date? = null,

        @field:NotNull
        @field:NotBlank
        val login: String? = null,

        @field:NotNull
        @field:NotBlank
        val password: String? = null,
)