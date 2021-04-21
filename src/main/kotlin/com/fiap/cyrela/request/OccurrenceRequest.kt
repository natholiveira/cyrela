package com.fiap.cyrela.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class OccurrenceRequest (
        @field:NotNull
        @field:NotBlank
        val ticketNumber: String? = null,

        @field:NotNull
        val unityId: Long? = null,

        @field:NotNull
        @field:NotBlank
        val description: String? = null
)