package com.fiap.cyrela.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class DevelopmentRequest (
        @field:NotNull
        @field:NotBlank
        val name: String? = null,

        @field:NotNull
        val addressId: Long? = null,

        @field:NotNull
        val block: BlockRequest
)

data class BlockRequest(
        @field:NotNull
        @field:NotBlank
        val name: String? = null,

        @field:NotNull
        val unity: UnityRequest
)

data class UnityRequest(
        @field:NotNull
        @field:NotBlank
        val number: String? = null,

        @field:NotNull
        @field:NotBlank
        val complement: String? = null,

        @field:NotNull
        val userId: Long? = null
)