package com.fiap.cyrela.request

import java.util.Date
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class ScheduleRequest (
        @field:NotNull
        @field:NotBlank
        val typeActivity: String,

        @field:NotNull
        val unityId: Long,

        @field:NotNull
        @field:NotBlank
        val subject: String,

        @field:NotNull
        val actualStart : Date,

        @field:NotNull
        val actualEnd: Date
)